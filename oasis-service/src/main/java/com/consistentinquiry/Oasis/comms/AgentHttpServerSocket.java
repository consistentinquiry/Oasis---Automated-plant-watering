package com.consistentinquiry.Oasis.comms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.consistentinquiry.Oasis.comms.exceptions.ServerSocketStartupFailureException;

import org.apache.commons.logging.Log;

public class AgentHttpServerSocket {

  private final int port;

  private ServerSocket serverSocket;

  private boolean listening;

  public AgentHttpServerSocket(int port) {
    this.port = port;
  }

  public void initialise()
      throws ServerSocketStartupFailureException {
    try {
      this.serverSocket = new ServerSocket(port);
      this.listening = true;
    } catch (IOException e) {
      throw new ServerSocketStartupFailureException(e);
    }
  }

  public void listen()
      throws IOException, ClassNotFoundException {

    while (listening) {
      Socket socket = serverSocket.accept();
      ObjectInputStream objectInputStream =
          new ObjectInputStream(socket.getInputStream());
      String message = (String) objectInputStream.readObject();
      Logger.getAnonymousLogger()
            .log(new LogRecord(Level.ALL, "Message received: " + message));
      ObjectOutputStream objectOutputStream =
          new ObjectOutputStream(socket.getOutputStream());
      objectOutputStream.writeObject("Hello there client!");
      objectInputStream.close();
      objectOutputStream.close();
      socket.close();
      if (message.equalsIgnoreCase("exit"))
        break;
    }
  }

  public void startServer() {

  }
}
