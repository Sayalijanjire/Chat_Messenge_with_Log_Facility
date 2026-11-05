# Chat Messenger with Log Facility

A simple **client-server chat application in Java** using TCP socket programming. The server records both client and server messages with timestamps in a local log file.

## Features
- TCP communication using `ServerSocket` and `Socket`
- Two-way, turn-based text messaging
- Timestamped chat history saved by the server
- Append-mode logging across sessions
- Type `end` to close the conversation
- Automatic creation of the `logs/` directory

## Technologies
- Java (standard library; JDK 8 or newer)
- `java.net` for socket communication
- `java.io` for console and file I/O
- `java.time` for timestamps

## Project Structure
```text
Chat-Messenger-with-Log-Facility/
├── ChatServer.java
├── ChatClient.java
├── README.md
├── .gitignore
└── logs/
    └── .gitkeep
```

## How to Run
Open a terminal in the project folder and compile both files:
```bash
javac ChatServer.java ChatClient.java
```

**Terminal 1 — Start the server first:**
```bash
java ChatServer
```

**Terminal 2 — Start the client:**
```bash
java ChatClient
```

Enter messages alternately in the client and server terminals. Type `end` on either side to finish the chat. The server stores the history in `logs/ChatLog.txt`.

## Example Chat Log
```text
----------- Chat Session Started: 2026-11-05T17:15:00 -----------
2026-11-05T17:15:10 Client: Hello Server
2026-11-05T17:15:15 Server: Hello Client
----------- Chat Session Ended: 2026-11-05T17:15:20 -----------
```
*Example only; actual timestamps and messages vary.*

## How It Works
1. The server listens on TCP port `2100`.
2. The client connects to `localhost:2100`.
3. The client sends a line of text; the server displays and logs it.
4. The server enters a reply; the client displays it, and the server logs it.
5. Messages continue alternately until a participant enters `end` or disconnects.

## Limitations
- Supports one client connection per server run.
- Messages are exchanged one at a time, not simultaneously.
- Communication is unencrypted and intended for local learning/demo use.
- Logs may contain private messages and are intentionally excluded from Git.

## Future Improvements
- Multithreaded support for multiple clients
- Usernames and session IDs
- GUI and chat history viewer
- Encrypted network communication
