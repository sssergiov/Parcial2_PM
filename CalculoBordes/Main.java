package CalculoBordes;

import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main extends javax.swing.JFrame{

	private static final int IMG_WIDTH = 380;
	private static final int IMG_HEIGHT = 368;
	BufferedImage Nueva_Imagen,imagen;
	int i,j,r,g,b,w,h;
	int[][] rojo,verde,azul,HorizontalR,VerticalR,HorizontalG,VerticalG,HorizontalB,VerticalB;
	int a[];    
	Color colorAuxiliar;
	public Main() {
		initComponents();
	}

	public void Inicializa(){
				
		Nueva_Imagen=new BufferedImage(imagen.getWidth(),imagen.getHeight(),BufferedImage.TYPE_INT_RGB) ;
		h=imagen.getHeight();
		w=imagen.getWidth();
		rojo=new int[w][h];
		verde=new int[w][h];
		azul=new int[w][h];
		HorizontalR=new int[w][h];
		HorizontalG=new int[w][h];
		HorizontalB=new int[w][h];
		VerticalR=new int[w][h];
		VerticalG=new int[w][h];
		VerticalB=new int[w][h];
		a=new int[w*h];
		for( i=0;i<imagen.getWidth();i++){
			for(j=0;j<imagen.getHeight();j++){
				colorAuxiliar=new Color(imagen.getRGB(i, j));

				r = colorAuxiliar.getRed();
				g= colorAuxiliar.getGreen();
				b = colorAuxiliar.getBlue();

				rojo[i][j]=r; 
				verde[i][j]=g; 
				azul[i][j]=b; 

			}
		}
	}
	
	private static BufferedImage resizeImage(BufferedImage originalImage, int type){
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();

		return resizedImage;
    }

	public void OperacionHorizontal(){
		for( i=0;i<imagen.getWidth()-1;i++){
			for(j=0;j<imagen.getHeight();j++){
				HorizontalR[i][j]=Math.abs((rojo[i+1][j]-rojo[i][j]));
				HorizontalG[i][j]=Math.abs((verde[i+1][j]-verde[i][j]));
				HorizontalB[i][j]=Math.abs((azul[i+1][j]-azul[i][j]));
				Nueva_Imagen.setRGB(i, j,new Color(HorizontalR[i][j],HorizontalG[i][j],HorizontalB[i][j]).getRGB());
			}
		}

	}

	public void OperacionVertical(){
		for( i=0;i<imagen.getWidth();i++){
			for(j=0;j<imagen.getHeight()-1;j++){
				VerticalR[i][j]=Math.abs((rojo[i][j+1]-rojo[i][j]));
				VerticalG[i][j]=Math.abs((verde[i][j+1]-verde[i][j]));
				VerticalB[i][j]=Math.abs((azul[i][j+1]-azul[i][j]));
				Nueva_Imagen.setRGB(i, j,new Color(VerticalR[i][j],VerticalG[i][j],VerticalB[i][j]).getRGB());
			}
		}
	}

	public int calculagradiente(int x,int y){
		double a,b,c;
		a=x*x;
		b=y*y;
		c=.5*Math.sqrt(a+b);
		//System.out.println("valor de gradiente "+c);
		return Math.round((float)(c));
	}

	public void Gradiente(){
		OperacionVertical();
		OperacionHorizontal();
		float sum = 0;
		for( i=0;i<imagen.getWidth()-1;i++){
			for(j=0;j<imagen.getHeight();j++){
				r=calculagradiente(HorizontalR[i][j],VerticalR[i][j]);
				g=calculagradiente(HorizontalG[i][j],VerticalG[i][j]);
				b=calculagradiente(HorizontalB[i][j],VerticalB[i][j]);
				Nueva_Imagen.setRGB(i, j,new Color(r,g,b).getRGB());
				sum = sum+r+g+b;
			}
		}		
		System.out.println(sum);
		comparar(sum);
	}

	private void comparar(float s) {
		Vector<Float> c = new Vector<Float>();
		boolean sw = false;
		c.add((float) 3954871.0);
		c.add((float) 2632053.0);
		c.add((float) 1666487.0);
		c.add((float) 1814719.0);
		c.add((float) 2340997.0);
		c.add((float) 4165251.0);
		c.add((float) 1165668.0);
		c.add((float) 2677662.0);
		c.add((float) 2391812.0);
		c.add((float) 1791599.0);
		c.add((float) 2160912.0);
		c.add((float) 2980017.0);
		c.add((float) 3278782.0);
		c.add((float) 1209307.0);
		c.add((float) 2599607.0);
		c.add((float) 998233.0);
		c.add((float) 1713152.0);
		c.add((float) 1266518.0);
		c.add((float) 910175.0);
		c.add((float) 1325586.0);
		c.add((float) 866598.0);
		c.add((float) 1471750.0);
		c.add((float) 782923.0);
		c.add((float) 463337.0);
		c.add((float) 2040531.0);
		c.add((float) 994244.0);
		c.add((float) 514134.0);
		c.add((float) 2812490.0);
		c.add((float) 2282156.0);
		c.add((float) 2564229.0);
		c.add((float) 1820732.0);
		c.add((float) 615832.0);
		c.add((float) 1339042.0);
		c.add((float) 1427793.0);
		c.add((float) 2896037.0);
		c.add((float) 842731.0);
		c.add((float) 797557.0);
		c.add((float) 4012166.0);
		c.add((float) 1253913.0);
		c.add((float) 6926803.0);
		c.add((float) 693102.0);
		c.add((float) 715780.0);
		c.add((float) 2304338.0);
		c.add((float) 1473625.0);
		c.add((float) 3230031.0);
		c.add((float) 1666487.0);
		c.add((float) 2986498.0);
		c.add((float) 2366251.0);
		c.add((float) 1964124.0);
		c.add((float) 1938851.0);
		c.add((float) 1938851.0);
		c.add((float) 3195343.0);
		c.add((float) 2276316.0);
		c.add((float) 2286000.0);
		c.add((float) 1575648.0);
		c.add((float) 2525383.0);
		c.add((float) 2480708.0);
		c.add((float) 1534529.0);
		c.add((float) 893237.0);
		
		
		for (int i = 0; i < c.size(); i++) {
			if (c.elementAt(i)==s) {
				System.out.println("Es una chompa");
				sw=true;
				break;
			}
		}
		if (!sw) {
			System.out.println("No se encontraron referencias");
		}
	}

	/* 		ARREGLAR ERRORES
	public void OperacionGradienteAprox(){
		// max{|P[i+1, j +1]−P[i, j]|+|P[i, j +1]−P[i+1, j]|,q−1}
		for( i=0;i<imagen.getWidth()-1;i++){
			for(j=0;j<imagen.getHeight()-1;j++){
				HorizontalR[i][j]=Math.abs((rojo[i+1][j+1]-rojo[i][j]));
				HorizontalG[i][j]=Math.abs((verde[i+1][j+1]-verde[i][j]));
				HorizontalB[i][j]=Math.abs((azul[i+1][j+1]-azul[i][j]));

			}
		}
	}
	 */

	public void Mostrar(){
		jLabelImagenResultado.setIcon(new ImageIcon(Nueva_Imagen));
	}

	private void initComponents() {

		jLabeltitulo1 = new javax.swing.JLabel();
		jLabeltitulo2 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jLabelImagenOriginal = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jLabelImagenResultado = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuGradienteAprox = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Deteccion de imagenes");

		jLabeltitulo1.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabeltitulo1.setForeground(new java.awt.Color(204, 0, 0));
		jLabeltitulo1.setText("Imagen Original");

		jLabeltitulo2.setFont(new java.awt.Font("Tahoma", 1, 11));
		jLabeltitulo2.setForeground(new java.awt.Color(204, 0, 0));
		jLabeltitulo2.setText("Imagen Resultante");

		jLabelImagenOriginal.setBackground(new java.awt.Color(255, 0, 0));
		jLabelImagenOriginal.setForeground(new java.awt.Color(255, 0, 102));
		jScrollPane2.setViewportView(jLabelImagenOriginal);

		jLabelImagenResultado.setForeground(new java.awt.Color(0, 51, 255));
		jScrollPane3.setViewportView(jLabelImagenResultado);
		

		jMenu1.setText("Archivo");

		jMenuItem1.setText("Abrir Imagen");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Metodo");

		jMenuGradienteAprox.setText("Gradiente");
		jMenuGradienteAprox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuGradienteAproxActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuGradienteAprox);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(248, 248, 248))
				.addGroup(layout.createSequentialGroup()
						.addGap(50, 50, 50)
						.addComponent(jLabeltitulo1)
						
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, Short.MAX_VALUE)
						.addComponent(jLabeltitulo2)
						.addGap(111, 111, 111))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabeltitulo1)
								.addComponent(jLabeltitulo2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(42, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
										.addComponent(jScrollPane2))
								.addGap(46, 46, 46)))
				);

		pack();
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser selector=new JFileChooser();
		selector.setDialogTitle("Seleccione una imagen");
		FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG &  BMP", "jpg", "bmp");
		selector.setFileFilter(filtroImagen);
		int flag=selector.showOpenDialog(null);
		if(flag==JFileChooser.APPROVE_OPTION){
			try {
				File imagenSeleccionada=selector.getSelectedFile();
				imagen= ImageIO.read(imagenSeleccionada);
			} catch (IOException e) {
			}
			
			BufferedImage originalImage = imagen;
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, type);
			imagen = resizeImageJpg;
			

			jLabelImagenOriginal.setIcon(new ImageIcon(imagen));
			Inicializa();  
		}
	}
	
	private void jMenuGradienteAproxActionPerformed(java.awt.event.ActionEvent evt) {
		//OperacionGradienteAprox();
		Gradiente();
		Mostrar();
	}


	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

	
	private javax.swing.JLabel jLabelImagenOriginal;
	private javax.swing.JLabel jLabelImagenResultado;
	private javax.swing.JLabel jLabeltitulo1;
	private javax.swing.JLabel jLabeltitulo2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuGradienteAprox;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;

}
