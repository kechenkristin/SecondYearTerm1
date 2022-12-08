from flask import Flask, render_template, request
import sqlite3 as sql
from Crypto.Cipher import AES as crypt
from Cryptodome.Cipher import XOR as crypt
import base64
import os.path
import html
app = Flask(__name__)

db = "database.db"
salt = "siMang6t"

def sqlescape(txt):
    return (str(txt).replace(";","&semi;").replace("'","&apos;"))


def get_cipher(key):
    cipher = crypt.new(str.encode(salt+key))
    return cipher

def encode_body(body, key):
    if key == '':
        body = str.encode(body)
    else:
        cipher = get_cipher(key)
        body = cipher.encrypt(body)
    return base64.b64encode(body)


def decode_body(body, key):
    body = (base64.b64decode(body)).decode()
    if not key == '':
        cipher = get_cipher(key)
        body = cipher.decrypt(body)
        body = body.decode()
    return body


@app.route('/')
def home():
    return render_template('home.html')


@app.route('/new')
def new_task():
    return render_template('new_task.html')


@app.route('/addrec', methods=['POST', 'GET'])
def addrec():
    if request.method == 'POST':
        con = sql.connect(db)
        msg = ""
        try:
            title = request.form['title']
            body = request.form['body']
            key = request.form['password']
            body = encode_body(body, key)
            cur = con.cursor()
            cur.executescript("INSERT INTO tasks (title,body) VALUES (" +
                              html.unescape(sqlescape(title)) + "," + html.unescape(sqlescape(body.decode())) +
                              ");")
            con.commit()
            msg = "Record successfully added"
        except:
            con.rollback()
            msg = "error in insert operation"

        finally:
            return render_template("result.html", msg=msg)
            con.close()


@app.route('/task')
def my_route():
    taskid = request.args.get('id', default=1)
    con = sql.connect(db)
    con.row_factory = sql.Row
    cur = con.cursor()
    cur.execute("select title,body from tasks where id=?", taskid)
    (title, body) = cur.fetchone()
    return render_template(
        "task.html",
        title=title,
        body=body,  # body.decode(),
        taskid=taskid)


@app.route('/decrypt', methods=['POST', 'GET'])
def decrypt():
    if request.method == 'POST':
        taskid = request.form['id']
        key = request.form['password']
        con = sql.connect(db)
        con.row_factory = sql.Row
        cur = con.cursor()
        cur.execute("select title,body from tasks where id=?", taskid)
        (title, body) = cur.fetchone()
        body = decode_body(body, key)
        return render_template("decrypt.html", title=title, body=body)


@app.route('/list')
def list():
    con = sql.connect(db)
    con.row_factory = sql.Row
    cur = con.cursor()
    cur.execute("select title,id from tasks")
    rows = cur.fetchall()
    return render_template("list.html", rows=rows)


if not os.path.isfile(db):
    with sql.connect(db) as conn:
        conn.execute(
            'CREATE TABLE tasks (id integer primary key, title TEXT, body TEXT)'
        )

if __name__ == '__main__':
    app.run()
