## ifconfig
lh@ML-RefVm-741459:~$ /sbin/ifconfig
docker0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 172.17.0.1  netmask 255.255.0.0  broadcast 172.17.255.255
        inet6 fe80::42:70ff:fe53:b46b  prefixlen 64  scopeid 0x20<link>
        ether 02:42:70:53:b4:6b  txqueuelen 0  (Ethernet)
        RX packets 5  bytes 181 (181.0 B)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 36  bytes 4716 (4.6 KiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

eth0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 10.0.0.126  netmask 255.255.240.0  broadcast 10.0.15.255
        inet6 fe80::6245:bdff:fe11:ea67  prefixlen 64  scopeid 0x20<link>
        ether 60:45:bd:11:ea:67  txqueuelen 1000  (Ethernet)
        RX packets 394925  bytes 438205201 (417.9 MiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 139520  bytes 34787754 (33.1 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

lo: flags=73<UP,LOOPBACK,RUNNING>  mtu 65536
        inet 127.0.0.1  netmask 255.0.0.0
        inet6 ::1  prefixlen 128  scopeid 0x10<host>
        loop  txqueuelen 1000  (Local Loopback)
        RX packets 14811  bytes 1136112 (1.0 MiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 14811  bytes 1136112 (1.0 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

veth11ed1f4: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet6 fe80::f091:34ff:fead:36bc  prefixlen 64  scopeid 0x20<link>
        ether f2:91:34:ad:36:bc  txqueuelen 0  (Ethernet)
        RX packets 50351  bytes 3545280 (3.3 MiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 37760  bytes 7354563 (7.0 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

veth3add8b1: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet6 fe80::b05e:b5ff:feab:311d  prefixlen 64  scopeid 0x20<link>
        ether b2:5e:b5:ab:31:1d  txqueuelen 0  (Ethernet)
        RX packets 3231  bytes 224598 (219.3 KiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 3269  bytes 172969 (168.9 KiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

vetha727acf: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet6 fe80::e4da:4aff:fed5:41c6  prefixlen 64  scopeid 0x20<link>
        ether e6:da:4a:d5:41:c6  txqueuelen 0  (Ethernet)
        RX packets 37727  bytes 7350942 (7.0 MiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 50394  bytes 3549904 (3.3 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

vethde553f2: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet6 fe80::bcc8:29ff:fe73:fce9  prefixlen 64  scopeid 0x20<link>
        ether be:c8:29:73:fc:e9  txqueuelen 0  (Ethernet)
        RX packets 3231  bytes 169038 (165.0 KiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 3297  bytes 232524 (227.0 KiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0


## nmap
lh@ML-RefVm-741459:~$ nmap 172.17.0.*
Starting Nmap 7.80 ( https://nmap.org ) at 2022-11-10 14:49 UTC
Nmap scan report for gateway (172.17.0.1)
Host is up (0.0031s latency).
Not shown: 998 closed ports
PORT     STATE SERVICE
22/tcp   open  ssh
3389/tcp open  ms-wbt-server

Nmap scan report for busstop (172.17.0.2)
Host is up (0.0031s latency).
Not shown: 997 closed ports
PORT    STATE SERVICE
13/tcp  open  daytime
79/tcp  open  finger
514/tcp open  shell

Nmap scan report for elementaryschoool (172.17.0.3)
Host is up (0.0031s latency).
Not shown: 996 closed ports
PORT    STATE SERVICE
13/tcp  open  daytime
21/tcp  open  ftp
79/tcp  open  finger
514/tcp open  shell

Nmap scan report for hellspass (172.17.0.4)
Host is up (0.0032s latency).
All 1000 scanned ports on hellspass (172.17.0.4) are closed

Nmap scan report for citywok (172.17.0.5)
Host is up (0.0032s latency).
All 1000 scanned ports on citywok (172.17.0.5) are closed

Nmap done: 256 IP addresses (5 hosts up) scanned in 3.62 seconds

## wireshark

> cat /etc/passwd

> sudo cat /etc/shadow

- 使用wireshark抓包后使用john 暴力破解


> /sbin/john format=crypt wireshark

exercise 1.2

