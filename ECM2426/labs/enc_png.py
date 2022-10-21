#!/usr/bin/python3
import png
from Cryptodome.Cipher import AES
from Cryptodome.Random import get_random_bytes


rdr = png.Reader('tux.png')
width, height, pixels, metadata = rdr.read_flat()

session_key = get_random_bytes(16)

aes = AES.new(session_key, AES.MODE_EAX)
cipherpixels = aes.encrypt(bytes(pixels))
output = open('tux.eax.png', 'wb')
writer = png.Writer(width, height, **metadata)
writer.write_array(output, cipherpixels)
output.close()

aes = AES.new(session_key, AES.MODE_ECB)
cipherpixels = aes.encrypt(bytes(pixels))
output = open('tux.ecb.png', 'wb')
writer = png.Writer(width, height, **metadata)
writer.write_array(output, cipherpixels)
output.close()

aes = AES.new(session_key, AES.MODE_CBC)
cipherpixels = aes.encrypt(bytes(pixels))
output = open('tux.cbc.png', 'wb')
writer = png.Writer(width, height, **metadata)
writer.write_array(output, cipherpixels)
output.close()

