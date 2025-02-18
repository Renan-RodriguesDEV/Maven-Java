package swing.renan.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;


import javax.swing.*;

import swing.renan.app.QueryCEP;
import swing.renan.entities.Endereco;

public class Window extends JFrame {

	JButton btn;
	JTextField field;
	JLabel label, uf, cep, bairro, logradoro, localidade, complemento;

	public Window() {
		ImageIcon img = new ImageIcon("https://dz2cdn1.dzone.com/storage/temp/12434118-spring-boot-logo.png");
		setIconImage(img.getImage());
		btn = new JButton("Consultar");
		field = new JTextField();
		label = new JLabel("CEP:");
		cep = new JLabel("");
		logradoro = new JLabel("");
		bairro = new JLabel("");
		uf = new JLabel("");
		localidade = new JLabel("");
		complemento = new JLabel("");
		JPanel p = new JPanel(new GridLayout(3, 2));
		JPanel pCEP = new JPanel(new GridLayout(3, 3));
		p.add(label, "North");
		p.add(field, "North");
		label.setForeground(new Color(255,255,255));
		btn.addActionListener((e) -> {
			QueryCEP query = new QueryCEP();
			String response = query.query(field.getText());
			Endereco endereco = query.JSONparseAddress(response);
			System.out.println(endereco);
			cep.setText(endereco.getCep());
			cep.setForeground(new Color(255,255,255) );
			logradoro.setText(endereco.getLogradouro());
			logradoro.setForeground(new Color(255,255,255) );
			bairro.setText(endereco.getBairro());
			bairro.setForeground(new Color(255,255,255) );
			uf.setText(endereco.getUf());
			uf.setForeground(new Color(255,255,255) );
			localidade.setText(endereco.getLocalidade());
			localidade.setForeground(new Color(255,255,255) );
			complemento.setText(endereco.getComplemento());
			complemento.setForeground(new Color(255,255,255) );
			pCEP.removeAll();
			pCEP.add(cep, "North");
			pCEP.add(logradoro, "North");
			pCEP.add(bairro, "North");
			pCEP.add(uf, "North");
			pCEP.add(localidade, "North");
			pCEP.add(complemento, "North");
			// Revalidar o layout após atualização
            pCEP.revalidate();
            pCEP.repaint();
			//pack();
		});
		add(p, "North");
		add(pCEP, "Center");
		add(btn, "South");
		p.setBackground(new Color(0,0,0) );
		p.setForeground(new Color(255,255,255) );
		pCEP.setBackground(new Color(0,0,0) );
		pCEP.setForeground(new Color(255,255,255) );
		setSize(900, 450);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// pack();

	}

	public static void main(String[] args) {
		new Window();
	}
}
