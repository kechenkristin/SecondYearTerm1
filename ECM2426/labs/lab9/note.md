> wfuzz -c -z file,/usr/share/wfuzz/wordlist/Injections/SQL.txt -d 'login=FUZZ&password=test1234' -u 'http://127.0.0.1:3000/sign_in'


https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/302

use the payload as username

http 500 code login fail

200 ok

302 found redirect

> wfuzz -c -z file,/usr/share/wfuzz/wordlist/Injections/SQL.txt -d 'login=FUZZ&password=test1234' -u 'http://127.0.0.1:3000/sign_in' | grep 302

find cookies in developer mode

parsing failures

encoders

/usr/local/ZAP_2.9.0/zap.sh
