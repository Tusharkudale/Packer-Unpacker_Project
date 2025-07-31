package MarvellousPackerUnpacker;
import java.util.*;
import java.io.*;

public class MarvellousPacker
{
    private String PackName;
    private String DirName;

    public MarvellousPacker(String A,String B)
    {
        this.PackName = A;
        this.DirName = B;
    }

    public void PakingActivity()
    {
        try
        {   
            System.out.println("--------------------------------------------------------------");
            System.out.println("----------------Marvellous Packer Unpacker--------------------");
            System.out.println("--------------------------------------------------------------");
            System.out.println("--------------------Packing Activity--------------------------");
            System.out.println("--------------------------------------------------------------");

            int i = 0,j = 0,iRet = 0,iCountFile = 0;
            
            File fobj = new File(DirName);

            //Check the existance of directory
            if(fobj.exists()  && fobj.isDirectory())
            {
                System.out.println(DirName+" is Successfully opened ");

                File Packobj = new File(PackName);

                //Create a Packed file
                boolean bRet = Packobj.createNewFile();
                
                if(bRet == false)
                {
                    System.out.println("Unable to create");
                    return;
                }

                System.out.println("Packed file gets successfully created with name: "+PackName);

                //Retrive all files from directory
                File Arr[] = fobj.listFiles();

                // Packed file object
                FileOutputStream foobj = new FileOutputStream(Packobj);
                
                //Buffer for read and Write activity
                byte Buffer[] = new byte[1024];
                

                String Header = null;

                //Header traversal
                for(i = 0;i < Arr.length;i++)
                {
                    Header = Arr[i].getName() + " " + Arr[i].length();
                    
                    //Loop to form 100 byte header
                    for(j = Header.length();j<100;j++)
                    {
                        Header = Header + " ";
                    }  
                    //write header into packed file
                    foobj.write(Header.getBytes());

                    //Open file from directory for reading
                    FileInputStream fiobj = new FileInputStream(Arr[i]);

                    //Write contents of files into packed file
                    while((iRet = fiobj.read(Buffer)) != -1 )
                    {
                        foobj.write(Buffer,0,iRet);
                        System.out.println("File name Scanned : "+Arr[i].getName());
                        System.out.println("File size read is : "+iRet);
                    }
                    fiobj.close();
                    iCountFile++;

                }
                System.out.println("Packing activity done");
                
                System.out.println("--------------------------------------------------------------");
                System.out.println("-------------------Statistical Report-------------------------");
                System.out.println("--------------------------------------------------------------");

                //To be add
                System.out.println("Total file Packed : "+iCountFile);

                System.out.println("--------------------------------------------------------------");
                System.out.println("------------Thank you for Using Our Application---------------");
                System.out.println("--------------------------------------------------------------");
            }
            else
            {
                System.out.println("There is no such directory");
            }
        }//End of try
        catch(Exception eobj)
        {}
    }//End of PackingActivity function
}//End of MarvellousPacker Class