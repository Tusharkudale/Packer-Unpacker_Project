package MarvellousPackerUnpacker;

import java.util.*;
import java.io.*;

class MarvellousUnpacker
{
    private String PackName;

    public MarvellousUnpacker(String A)
    {
        this.PackName = A;
    }

    public void UnpackingActivity()
    {
        try
        {  
            System.out.println("--------------------------------------------------------------");
            System.out.println("----------------Marvellous Packer Unpacker--------------------");
            System.out.println("--------------------------------------------------------------");
            System.out.println("--------------------Packing Activity--------------------------");
            System.out.println("--------------------------------------------------------------");

            int FileSize = 0,iRet = 0,iCountFile = 0;
            String Header = null;
            File fobjnew = null;
            
            File fobj = new File(PackName);

            //if packed file is not present
            if(!fobj.exists())
            {
                System.out.println("Unable to access packed file");
                return;
            }
            System.out.println("Packed file gets successfully opened");
            FileInputStream fiobj = new FileInputStream(fobj);

            //Buffer to read header
            byte HeaderBuffer[] = new byte[100];

            //Scan the packed file to extract the files from it
            while((iRet = fiobj.read(HeaderBuffer,0,100)) != -1 )
            {
            
            //Convert Byte Array to String
             Header = new String(HeaderBuffer);

            Header = Header.trim();

            //Tokenize the header into two parts
            String Tokens[] = Header.split(" ");

            fobjnew = new File(Tokens[0]);

            //Create new file to extract
            fobjnew.createNewFile();

            FileSize = Integer.parseInt(Tokens[1]);

            //Create new buffer to store files data
            byte Buffer[] = new byte[FileSize];

            FileOutputStream foobj = new FileOutputStream(fobjnew);

            //Read the data from packed file
            fiobj.read(Buffer,0,FileSize);

            //Write the data into extracted file
            foobj.write(Buffer,0,FileSize);

            System.out.println("File unpacked with name : "+Tokens[0]+" having size "+FileSize);

            iCountFile++;

            foobj.close();

            }//End of while

            System.out.println("--------------------------------------------------------------");
            System.out.println("-------------------Statistical Report-------------------------");
            System.out.println("--------------------------------------------------------------");

            System.out.println("Total number if files unpaked : "+iCountFile);

            System.out.println("--------------------------------------------------------------");
            System.out.println("------------Thank you for Using Our Application---------------");
            System.out.println("--------------------------------------------------------------");

            fiobj.close();
        }
        catch(Exception eobj)
        {}
    }
}