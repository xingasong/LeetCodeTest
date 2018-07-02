import java.io.*;

public class testFile {

    public static void main(String[] args) {
        int fileSize = 360;
        int pieceSize = 80;
        int numOfPiece;
        if(fileSize%pieceSize==0) {
            numOfPiece = fileSize/pieceSize;
        }else {
            numOfPiece = fileSize/pieceSize +1;
        }
        int lastSize = fileSize-(numOfPiece-1)*pieceSize;

        //divide
        try {
            String pathName = "/Users/singasong/Documents/testfile.txt";
            //File newFile = new File(pathName);
            //fileSize = newFile.length();
            FileInputStream fileIn = new FileInputStream(pathName);
            //byte[] filebuf = new byte[(int)fileSize];
            byte[] filebuf = new byte[fileSize];
            int m = fileIn.read(filebuf);
            //pieceSize = (int)fileSize/3;
            //pieceSize = 121;
            for (int i=0; i<numOfPiece-1; i++) {
                //File writename = new File("/Users/singasong/Documents/testfile" + i + ".part");
                //writename.createNewFile(); //
                FileOutputStream fileOut = new FileOutputStream("/Users/singasong/Documents/testfile" + i + ".part");
                fileOut.write(filebuf, pieceSize*i, pieceSize);
                fileOut.flush();
                fileOut.close();
            }

            FileOutputStream fileOut = new FileOutputStream("/Users/singasong/Documents/testfile" + (numOfPiece-1) + ".part");
            fileOut.write(filebuf, pieceSize * (numOfPiece - 1), lastSize);
            fileOut.flush();
            fileOut.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        //combine
        try {
            BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream("/Users/singasong/Documents/retestfile.txt"));
            //System.out.println("trying to recontribute flie " + fileName +" at " +outFilePath);
            try {
                for (int i = 0; i < numOfPiece; i++) {
                    byte[] buf = new byte[pieceSize];
                    FileInputStream inStream = new FileInputStream("/Users/singasong/Documents/testfile" + i + ".part");
                    //System.out.println("trying to recontribute part " + i +" of the file");
                    int count;
                    if ((count = inStream.read(buf)) != 0) {
                        outStream.write(buf, 0, count);
                        //System.out.println("part" + i + " recontribute successfully");
                    }
                    inStream.close();
                }
                outStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
