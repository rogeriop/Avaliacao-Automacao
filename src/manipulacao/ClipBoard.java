package manipulacao;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipBoard {
	//** Obtem do clipboard			
	public String obtem() throws UnsupportedFlavorException, IOException {

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
		Transferable contents = clipboard.getContents(this);  
		String texto;
		if (contents == null) {  
		    texto = null;  
		} else if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {  
		    texto = (String) contents.getTransferData(DataFlavor.stringFlavor);  
		    // TODO processar o texto  
		} else {  
		    texto = null;  
		}  
		return texto;
	}

	//** Copia para o clipboard
	public void copia(String texto) { 
		
		Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();  
        ClipboardOwner selection = new StringSelection(texto);  
        board.setContents((Transferable) selection, selection);  

	}

}
