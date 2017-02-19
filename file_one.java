package file_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Vector;

public class file_one {
	final static Integer unit_byte = 20000000;
	public static void main(String[] args) {
		try {
	
			File file = new File("11.rmvb");
			int hehe = (int) (file.length()/unit_byte);
			int yu_shu = (int) (file.length()%unit_byte);
			
			Integer [] ii = new Integer[hehe+1];
			
			for(int i=0;i<hehe+1;i++)
			{
				ii[i] = unit_byte;
			}
			ii[hehe] = yu_shu;
		
			FileInputStream fis = new FileInputStream(file);
	
			Vector<Integer> Text_Cursor = new Vector<Integer>();
		
			byte[] b = new byte[unit_byte];
	
			int location;
	
			while((location=fis.read(b))!=-1)
			{	
				System.out.println("b de"+b[0]);
				Text_Cursor.add(location);
				System.out.println("location"+location);
			}
			fis.close();
			
			FileInputStream fis1 = new FileInputStream("11.rmvb");
			FileOutputStream fos = new FileOutputStream("1111.rmvb",true);
			int AmountOfSize = ii.length;
			for(int i=0;i<AmountOfSize;i++)
			{
				byte[] bb = new byte[ii[i]];

				fis1.read(bb);
				System.out.println(bb[0]);
				System.out.println(bb[1]);
				fos.write(bb);
				bb = null;
				fos.flush();
			}
			fos.close();
			fis1.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}


