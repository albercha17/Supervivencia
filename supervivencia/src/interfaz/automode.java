package interfaz;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import supervivencia.supervivencia;

public class automode extends JFrame{
	
	private JPanel contentPanel;
	
	private String frase,archivo;
	private JLabel label,supervivientes,label2;
	private supervivencia sumode;
	ImageIcon iconol;
	private boolean r,compi2;
	public automode() throws IOException {
		frase="";
		archivo="";
		r=false;
		sumode=null;
		compi2=false;
	}
	
	public void init() {
		// TODO Auto-generated method stub
		
				this.setVisible(true);
				setTitle("Supervivencia");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(-4, 00, 2450, 1050);
				JPanel contentPane = new JPanel();
				contentPane.setForeground(new Color(32, 178, 170));
				contentPane.setBackground(new Color(32, 178, 170));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));

				JPanel panel = new JPanel();
				panel.setBackground(new Color(32, 178, 170));
				contentPane.add(panel, BorderLayout.NORTH);

				JLabel lblNewLabel = new JLabel("SUPERVIVENCIA");

				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 60));
				panel.add(lblNewLabel);

				
				JPanel panel_botones = new JPanel();
				panel_botones.setBackground(new Color(32, 178, 170));
				contentPane.add(panel_botones, BorderLayout.CENTER);
				
				JToolBar barraBotones = new JToolBar();
				barraBotones.setForeground(new Color(32, 178, 170));
				barraBotones.setBackground(new Color(32, 178, 170));
				barraBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
				
				JButton madrid = new JButton("MADRID");
				madrid.setFont(new Font("Consolas", Font.PLAIN, 18));
				madrid.setForeground(new Color(0, 0, 0));
				madrid.setLayout(new GridLayout(5, 2, 50, 25));
				
				JButton pueblo = new JButton("PUEBLO");
				pueblo.setFont(new Font("Consolas", Font.PLAIN, 18));
				pueblo.setForeground(new Color(0, 0, 0));
				pueblo.setLayout(new GridLayout(5, 2, 50, 25));
				
				JButton famosos = new JButton("FAMOSOS");
				famosos.setFont(new Font("Consolas", Font.PLAIN, 18));
				famosos.setForeground(new Color(0, 0, 0));
				famosos.setLayout(new GridLayout(5, 2, 50, 25));
				
				JLabel s = new JLabel(" ");
				s.setFont(new Font("Consolas", Font.PLAIN, 18));
				s.setLayout(new GridLayout(5, 2, 50, 25));
				s.setForeground(new Color(32, 178, 170));
				s.setBackground(new Color(32, 178, 170));
				s.setBorder(new EmptyBorder(5, 5, 5, 5));
				
				JLabel s2 = new JLabel("               ");
				s.setFont(new Font("Consolas", Font.PLAIN, 18));
				s.setLayout(new GridLayout(5, 2, 50, 25));
				s.setForeground(new Color(32, 178, 170));
				s.setBackground(new Color(32, 178, 170));
				s.setBorder(new EmptyBorder(5, 5, 5, 5));
				
				JButton todos = new JButton("TODOS");
				todos.setFont(new Font("Consolas", Font.PLAIN, 18));
				todos.setForeground(new Color(0, 0, 0));
				todos.setLayout(new GridLayout(5, 2, 50, 25));
				
				JCheckBox  compi = new JCheckBox("ALIANZAS");
				compi.setFont(new Font("Consolas", Font.PLAIN, 18));
				compi.setForeground(new Color(0, 0, 0));
				compi.setLayout(new GridLayout(5, 2, 50, 25));
				
				JButton bomba = new JButton("");
				bomba.setFont(new Font("Consolas", Font.PLAIN, 18));
				bomba.setForeground(new Color(0, 0, 0));
				bomba.setLayout(new GridLayout(5, 2, 50, 25));
				Icon icono2 = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\bomba.png");
				bomba.setIcon(icono2);
				bomba.setToolTipText("bomba");
				bomba.setEnabled(false);
				
				barraBotones.add(madrid);
			    barraBotones.add(pueblo);
			    barraBotones.add(famosos);
			    barraBotones.add(todos);
			    barraBotones.add(s);
			    barraBotones.add(compi);
			    barraBotones.add(s2);
			    barraBotones.add(bomba);
			    panel_botones.add(barraBotones, BorderLayout.NORTH);
				
				
				JButton jugarNormal = new JButton("EMPEZAR");
				jugarNormal.setFont(new Font("Consolas", Font.PLAIN, 18));
				jugarNormal.setForeground(new Color(0, 0, 0));
				panel_botones.setLayout(new GridLayout(5, 2, 50, 25));
				jugarNormal.setEnabled(false);
				panel_botones.add(jugarNormal);
				

			
				
				iconol = null;
				label = new JLabel(frase);				
				label.setIcon((Icon) iconol);
				label.setIconTextGap(1);
				label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
		        label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		        label.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
				label.setBounds(0,0,10,10);
				label.setFont(new Font("Consolas", Font.PLAIN, 40));
				label.setForeground(Color.WHITE);
				label.setVisible(true);
				panel_botones.add(label);
				
				JLabel supervivientesT = new JLabel("SUPERVIVIENTES");
				supervivientesT.setBounds(10,50,10,10);
				supervivientesT.setFont(new Font("Consolas", Font.PLAIN, 24));
				supervivientesT.setForeground(Color.WHITE);
				supervivientesT.setVisible(true);
				panel_botones.add(supervivientesT);
				
				supervivientes = new JLabel(frase);
				supervivientes.setBounds(10,50,10,10);
				supervivientes.setFont(new Font("Consolas", Font.PLAIN, 15));
				supervivientes.setForeground(Color.WHITE);
				supervivientes.setVisible(true);
				panel_botones.add(supervivientes);
				
				JPanel _exitPanel = new JPanel();
				_exitPanel.setBackground(Color.white);
				contentPane.add(_exitPanel, BorderLayout.SOUTH);

				JButton JUGARo  = new JButton("JUGAR DE NUEVO");
				JUGARo.setForeground(new Color(0, 0, 0));
				JUGARo.setFont(new Font("Consolas", Font.PLAIN, 32));
				JUGARo.setVisible(false);
				_exitPanel.add(JUGARo);
				JButton atras  = new JButton("ELEGIR MODO");
				atras.setForeground(new Color(0, 0, 0));
				atras.setFont(new Font("Consolas", Font.PLAIN, 32));
				_exitPanel.add(atras);
				
				JButton _btnOut = new JButton("SALIR");
				_btnOut.setForeground(new Color(0, 0, 0));
				_btnOut.setFont(new Font("Consolas", Font.PLAIN, 32));
				_exitPanel.add(_btnOut);
				
				
				
				
				/* ActionListener */

				jugarNormal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						while(!sumode.getAcabado()) {
							try {
								Thread.sleep(3000);
								frase=sumode.jugar();
								label.setText(frase);
								supervivientes.setText(sumode.getSupervivientes());
								if(sumode.getAcabado()) {
									label.setForeground(Color.YELLOW);
									label.setFont(new Font("Consolas", Font.PLAIN, 30));
								}
								if(sumode.getAccion()=="resucitar") {
									iconol = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\resurrecion.png");
									label.setIcon(iconol);
							    }
								else if(sumode.getAccion()=="muerto") {
										iconol = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\muerte.png");
										label.setIcon(iconol);
								}
								else if(sumode.getAccion()=="escudo") {
									iconol = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\escudo.png");
									label.setIcon(iconol);
							}
								else if(sumode.getAccion()=="dañar") {
									iconol = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\dañar.png");
									label.setIcon(iconol);
							}
								else if(sumode.getAccion()=="ganar") {
									iconol = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\ganar.png");
									label.setIcon(iconol);
							}else if(sumode.getAccion()=="dianormal") {
								iconol = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\diaN.png");
								label.setIcon(iconol);
						}
							else if(sumode.getAccion()=="alianza") {
								iconol = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\alianza.png");
								label.setIcon(iconol);
						}
							
							else {
								iconol = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\diaN.png");
								label.setIcon(iconol);
							}

								if(sumode.getAcabado()) {
									JUGARo.setVisible(true);
								}	
								
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
		}
});
				JUGARo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						automode modoNormal = null;
						try {
							modoNormal = new automode();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						modoNormal.init();	
					}
				});
				atras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						guiPrincipal principal = null;
						try {
							principal = new guiPrincipal();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				
				_btnOut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				madrid.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						archivo="C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\madrid.txt";
						try {
							if (compi.isSelected()==true) compi2=true;
							sumode=new supervivencia(archivo,compi2);
							compi.setEnabled(false);
							madrid.setEnabled(false);
							pueblo.setEnabled(false);
							todos.setEnabled(false);
							famosos.setEnabled(false);
							jugarNormal.setEnabled(true);
							bomba.setEnabled(true);

							label.setText("QUE EMPIEZE LA BATALLA!!!!");
							supervivientes.setText(sumode.getSupervivientes());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				pueblo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						archivo="C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\pueblo.txt";
						try {
							if (compi.isSelected()==true) compi2=true;
					        
							sumode=new supervivencia(archivo,compi2);
							compi.setEnabled(false);
							madrid.setEnabled(false);
							pueblo.setEnabled(false);
							famosos.setEnabled(false);
							todos.setEnabled(false);
							jugarNormal.setEnabled(true);
							bomba.setEnabled(true);

							label.setText("QUE EMPIEZE LA BATALLA!!!!");
							supervivientes.setText(sumode.getSupervivientes());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				famosos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						archivo="C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\famosos.txt";
						try {
							if (compi.isSelected()==true) compi2=true;
							sumode=new supervivencia(archivo,compi2);
							compi.setEnabled(false);
							madrid.setEnabled(false);
							pueblo.setEnabled(false);
							famosos.setEnabled(false);
							todos.setEnabled(false);
							jugarNormal.setEnabled(true);
							bomba.setEnabled(true);

							label.setText("QUE EMPIEZE LA BATALLA!!!!");
							supervivientes.setText(sumode.getSupervivientes());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				todos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						archivo="C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\todos.txt";
						try {
							if (compi.isSelected()==true) compi2=true;
							sumode=new supervivencia(archivo,compi2);
							compi.setEnabled(false);
							madrid.setEnabled(false);
							todos.setEnabled(false);
							pueblo.setEnabled(false);
							famosos.setEnabled(false);
							jugarNormal.setEnabled(true);
							bomba.setEnabled(true);

							label.setText("QUE EMPIEZE LA BATALLA!!!!");
							supervivientes.setText(sumode.getSupervivientes());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				bomba.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						iconol = new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\iconos\\bomba.png");
						label.setIcon(iconol);
							label.setText(sumode.bomba());
							supervivientes.setText(sumode.getSupervivientes());
						
						
					}
				});
				
				
				
				
				
				
				
				
				
				
				
				
			}
}