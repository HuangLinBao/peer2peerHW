# peer2peerHW
Is my Homework for the Networks project which is a very simple chat client that is supposed to handle TCP and UDP chatting. UDP being direct peer to peer and TCP
being through a [TCP Server](https://github.com/HuangLinBao/TCP_Server) that handles Login, Logout and Sending messages, and the last part being able to send a file
using UDP protocol

## Screenshots
![alt text](https://imgur.com/Ky3VOpS.png)


As you can see here we have the client side or the peer, we have the username feild, TextAreas for the Shown messages and as a textBox to write messages to be sent
Along side the "Send" button, fields for IPs and Port Numbers for TCP server, remote and local peers and Finaly the Online List.
The login/logout buttons are for TCP and connect/disconnect are for UDP.
The "Available Interfaces" Drop down menu is static and doesn't work.
The "Status" field and "Test" Button do not work
The "Open" button is to open a file choser so we can send a .txt file *UDP ONLY*





![alt text](https://imgur.com/xp61Dh4.png)


Here we have the TCP server Layout which just contains the port feild and the online users list and the "Start Listening" button *the Only things that are working*.

## How does it work
### UDP
the code just runs two threads in the background once you click "connect" button, one for sending the messages and the other one is for receiving them.

### TCP
the code opens several threads once you click the "Login button", one for handling online list fetching and one is for Loging in and two for handling messages
"Send and Receive". The Login Thread sends the credentials [Username-LocalIp-LocalPort] to the TCP server and the server gives back the list of online users.
The MsgThread sends the message as [The message with the username , remoteIP , remotePort] to the TCP server so it can redirect the code to the targeted user.
See [The Server Repo](https://github.com/HuangLinBao/TCP_Server) for more information.


## Problems
There is a problem with the TCP part of the HW which is the long time to wait untill a message is received and redirected weather the process was the Login to fetch
online users or the message redirection, it's either a really long wait or a Connection timedout exception.

## Demo for UDP

[Here is the demo for the project](https://www.youtube.com/watch?v=iS0k9OOGw4g)



