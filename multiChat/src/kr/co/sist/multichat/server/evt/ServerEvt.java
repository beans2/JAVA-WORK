package kr.co.sist.multichat.server.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.net.ServerSocket;

import kr.co.sist.multichat.server.view.ServerView;

public class ServerEvt extends WindowAdapter implements ActionListener, Runnable {
   
   private ServerView sv;
   private Thread threadServer;
   private ServerSocket server;
//   private List<>
   
   public ServerEvt( ServerView sv) {
      this.sv = sv;
   }//ServerEvt

   @Override
   public void run() {
      
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
      if( ae.getSource() == sv.getJbStart() ) {
         System.out.println("start");
      }else if (ae.getSource() ==sv.getJbClose()) {
         sv.dispose();
      }
   }


}//class