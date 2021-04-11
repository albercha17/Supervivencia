package interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class guiPrincipal extends JFrame {	
	private JPanel contentPane;
	private normalMode modoNormal;
	private normalModeEquipos modoEquipos;
	private normalModeDuo modoDuo;
	private automode automo;
	public guiPrincipal() throws IOException {
		initialize();
		modoNormal=new normalMode();
		modoEquipos=new normalModeEquipos();
		modoDuo=new normalModeDuo();
		automo= new automode();
	}
	
	public void initialize() {
		// TODO Auto-generated method stub
		
		this.setVisible(true);
		setTitle("Supervivencia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-4, 00, 2450, 1050);
		contentPane = new JPanel();
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
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 32));
		panel.add(lblNewLabel);

		JPanel panel_botones = new JPanel();
		panel_botones.setBackground(new Color(32, 178, 170));
		contentPane.add(panel_botones, BorderLayout.CENTER);

		JButton jugarNormal = new JButton("MODO NORMAL");
		jugarNormal.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton jugarPorEquipos = new JButton("MODO EQUIPOS");
		jugarPorEquipos.setFont(new Font("Consolas", Font.PLAIN, 18));
		JButton jugarDuos = new JButton("MODO DUOS");
		jugarDuos.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton autom = new JButton("MODO AUTO");
		autom.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		panel_botones.setLayout(new GridLayout(5, 2, 50, 25));
		panel_botones.add(jugarNormal);
		panel_botones.add(jugarPorEquipos);
		panel_botones.add(jugarDuos);
		panel_botones.add(autom);
		
		JPanel _exitPanel = new JPanel();
		_exitPanel.setBackground(Color.white);
		contentPane.add(_exitPanel, BorderLayout.SOUTH);

		JButton _btnOut = new JButton("SALIR");
		_btnOut.setForeground(new Color(0, 0, 0));
		_btnOut.setFont(new Font("Consolas", Font.PLAIN, 32));
		_exitPanel.add(_btnOut);

		/* ActionListener */
		jugarNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				modoNormal.init();		
			}
		});
		jugarPorEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				modoEquipos.init();		
			}
		});
		jugarDuos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				modoDuo.init();
			}
		});
		_btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		autom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				automo.init();
			}
		});

		
		
	}

}
