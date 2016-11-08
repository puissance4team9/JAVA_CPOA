/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPSClient;

/**
 *
 * @author p1406759
 */

public class FTPUploadfile {
    

 public FTPUploadfile(String chemin_src, String chemin_dest,String nomfichier) {
  String serveur = "iutdoua-samba.univ-lyon1.fr";
  int port = 990;
  String user = "p1406759";
  String password = "Nasro1995";
   boolean result;
  FTPSClient ftpClient = new FTPSClient();
  try {

   ftpClient.connect(serveur, port);
   result=ftpClient.login(user, password );
   
   if(result==true)
       {
                System.out.println("User logged in successfully !");
        } else {
                System.out.println("Login Fail !");
                return;}
   
   ftpClient.enterLocalPassiveMode();
   ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
   
   
//   result=ftpClient.changeWorkingDirectory(chemin);
//   if (result == true) {
//   System.out.println("Working directory is changed.Your New working directory:");
//        } else {
//                System.out.println("Unable to change");
//        }
//        result = ftpClient.changeToParentDirectory();
//        if (result == true) {
//                System.out.println("Parent directory is changed");
//        } else {
//                System.out.println("Unable to change Parent directory");
//                }
////   // Approche 1: upload d'un fichier en utilisant InputStream
   File file = new File(chemin_src);

   FileInputStream inputStream = new FileInputStream(file);

   System.out.println("Début de l'upload");
   //résultat de l'upload
   boolean res = ftpClient.storeFile(chemin_dest+nomfichier,inputStream);
   //fermet le flut de lecture
   inputStream.close();
   
   if (res==true) {
     System.out.println("Le fichier "+chemin_dest+" a été transféré avec succès");
   }else{
     System.out.println("Echec de transfert");
   }

  } catch (IOException e) {
   System.out.println(e.getMessage());
   e.printStackTrace();
  } finally {
   try {
    if (ftpClient.isConnected()) {
     //fermer la connexion FTP
     ftpClient.logout();
     ftpClient.disconnect();
    }
   } catch (IOException ex) {
    ex.printStackTrace();
   }
  }
 }
}
