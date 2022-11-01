## ECM2426CA

### Using VM
> ssh -p 56300 lh@ml-lab-ea7983db-576e-4a96-b9dd-c35e52f8ed40.uksouth.cloudapp.azure.com

user: lh

password: Initial1

### E1
#### E.1.1
- question

List all users with their login that have numerical user id larger than 1000.
Submit your answer in cell B2 of the spreadsheet ecm2426.ods. Separate the
logins with a comma, e.g., “joe, jane, root”.

> cat /etc/passwd

- record

```
lh@ML-RefVm-741459:~/solution$ cat /etc/passwd

root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
bin:x:2:2:bin:/bin:/usr/sbin/nologin
sys:x:3:3:sys:/dev:/usr/sbin/nologin
sync:x:4:65534:sync:/bin:/bin/sync
games:x:5:60:games:/usr/games:/usr/sbin/nologin
man:x:6:12:man:/var/cache/man:/usr/sbin/nologin
lp:x:7:7:lp:/var/spool/lpd:/usr/sbin/nologin
mail:x:8:8:mail:/var/mail:/usr/sbin/nologin
news:x:9:9:news:/var/spool/news:/usr/sbin/nologin
uucp:x:10:10:uucp:/var/spool/uucp:/usr/sbin/nologin
proxy:x:13:13:proxy:/bin:/usr/sbin/nologin
www-data:x:33:33:www-data:/var/www:/usr/sbin/nologin
backup:x:34:34:backup:/var/backups:/usr/sbin/nologin
list:x:38:38:Mailing List Manager:/var/list:/usr/sbin/nologin
irc:x:39:39:ircd:/run/ircd:/usr/sbin/nologin
gnats:x:41:41:Gnats Bug-Reporting System (admin):/var/lib/gnats:/usr/sbin/nologin
nobody:x:65534:65534:nobody:/nonexistent:/usr/sbin/nologin
_apt:x:100:65534::/nonexistent:/usr/sbin/nologin
messagebus:x:101:101::/nonexistent:/usr/sbin/nologin
uuidd:x:102:102::/run/uuidd:/usr/sbin/nologin
tcpdump:x:103:103::/nonexistent:/usr/sbin/nologin
systemd-network:x:104:105:systemd Network Management,,,:/run/systemd:/usr/sbin/nologin
systemd-resolve:x:105:106:systemd Resolver,,,:/run/systemd:/usr/sbin/nologin
_chrony:x:106:112:Chrony daemon,,,:/var/lib/chrony:/usr/sbin/nologin
sshd:x:107:65534::/run/sshd:/usr/sbin/nologin
systemd-coredump:x:998:998:systemd Core Dumper:/:/usr/sbin/nologin
lh:x:1000:1000:Debian:/home/lh:/bin/bash
syslog:x:997:997::/home/syslog:/bin/false
usbmux:x:108:46:usbmux daemon,,,:/var/lib/usbmux:/usr/sbin/nologin
rtkit:x:109:115:RealtimeKit,,,:/proc:/usr/sbin/nologin
avahi:x:110:117:Avahi mDNS daemon,,,:/run/avahi-daemon:/usr/sbin/nologin
saned:x:111:118::/var/lib/saned:/usr/sbin/nologin
colord:x:112:119:colord colour management daemon,,,:/var/lib/colord:/usr/sbin/nologin
pulse:x:113:120:PulseAudio daemon,,,:/run/pulse:/usr/sbin/nologin
geoclue:x:114:122::/var/lib/geoclue:/usr/sbin/nologin
Debian-gdm:x:115:123:Gnome Display Manager:/var/lib/gdm3:/bin/false
ntp:x:116:125::/nonexistent:/usr/sbin/nologin
Debian-exim:x:117:126::/var/spool/exim4:/usr/sbin/nologin
logcheck:x:118:129:logcheck system account,,,:/var/lib/logcheck:/usr/sbin/nologin
xrdp:x:119:131::/run/xrdp:/usr/sbin/nologin
wurzel:x:999:999:,,,:/wurzel:/bin/bash
clamav:x:120:132::/var/lib/clamav:/bin/false
alice:x:1001:1003:Alice Dolev,,,:/home/alice:/bin/bash
bob:x:1002:1004:Bob HoNESt10 Agent,,,:/home/bob:/bin/bash
charlie:x:1003:1005:Charlie Yao,,,:/home/charlie:/bin/bash
eve:x:1004:1006:Eve,,,:/home/eve:/bin/bash
systemd-timesync:x:996:999:systemd Time Synchronization:/:/usr/sbin/nologin
```
- solution

alice, bob, charlie, eve



#### E.1.2
- pre
> sudo cat /etc/shadow
> cat /etc/shadow | grep bob 

- res

	- https://blog.csdn.net/lws123253/article/details/89228589

	- https://3gstudent.github.io/Linux%E4%B8%8B%E7%9A%84%E5%AF%86%E7%A0%81Hash-%E5%8A%A0%E5%AF%86%E6%96%B9%E5%BC%8F%E4%B8%8E%E7%A0%B4%E8%A7%A3%E6%96%B9%E6%B3%95%E7%9A%84%E6%8A%80%E6%9C%AF%E6%95%B4%E7%90%86

	- https://unix.stackexchange.com/questions/430141/how-to-find-the-hashing-algorithm-used-to-hash-passwords

- question

Execute a guessing attack on the password for the user bob. What is the
password of bob.

Submit your answer in cell B3 of the spreadsheet ecm2426.ods.

- record
```
```

#### E.1.3
- pre
> su - alice
> cat /exercise1/flag

- question

What is the content of the file /home/alice/exercise1/flag.
Submit your answer in cell B4 of the spreadsheet ecm2426.ods

- record

```
lh@ML-RefVm-741459:~/solution$ su - alice
Password: 

alice@ML-RefVm-741459:~$ ls
exercise01  exercise02

alice@ML-RefVm-741459:~$ cd exercise01

alice@ML-RefVm-741459:~/exercise01$ ls -l
total 4
-rwxr-----+ 1 alice alice 76 Nov  1 19:10 flag

alice@ML-RefVm-741459:~/exercise01$ cat flag 
10.0.0.29 :5329ccb5a3ac7f8cfa6456d8abe097e123a060f86a7cf31ef71a9dc503fcb1ef
```
- solution

10.0.0.29 :5329ccb5a3ac7f8cfa6456d8abe097e123a060f86a7cf31ef71a9dc503fcb1ef

#### E.1.4
- pre
> ls -l 
> getent group groupname

- question

List all users with their login that can read the file /home/alice/exercise1/flag. Separate the logins with a comma, e.g., “joe, jane, root''.
Submit your answer in cell B5 of the spreadsheet ecm2426.ods.

- record

```
alice@ML-RefVm-741459:~/exercise01$ ls -l
total 4
-rwxr-----+ 1 alice alice 76 Nov  1 19:10 flag

alice@ML-RefVm-741459:~/exercise01$ getent group alice
alice:x:1003:

alice@ML-RefVm-741459:~/exercise01$ groups
alice student

alice@ML-RefVm-741459:~/exercise01$ getent group student 
student:x:1002:alice,bob,charlie,eve
```

- solution

alice
