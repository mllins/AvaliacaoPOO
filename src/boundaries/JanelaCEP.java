package boundaries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entities.BuscaCEP;

public class JanelaCEP {
	
	private JTextField tfCep;
	private JTextField tfLogradouro;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfEstado;
	private JTextField tfUnidade;
	private JTextField tfIbge;
	private JTextField tfGia;

	public void buscaCEP() {
		JDialog janela = new JDialog();
		janela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		janela.setSize(440, 350);
		janela.setLayout(null);
		
		JLabel lblCep = new JLabel("CEP:");
		tfCep = new JTextField();
		lblCep.setBounds(10, 10, 100, 20);
		tfCep.setBounds(10, 30, 80, 20);
		janela.add(lblCep);
		janela.add(tfCep);
		
		JButton btnBusca = new JButton("Buscar CEP");
		btnBusca.setBounds(120, 20, 150, 30);
		janela.add(btnBusca);
		btnBusca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				executaBusca();
			}
			
		});

		JLabel lblLogradouro = new JLabel("Logradouro:");
		tfLogradouro = new JTextField();
		lblLogradouro.setBounds(10, 60, 100, 20);
		tfLogradouro.setBounds(10, 80, 400, 20);
		janela.add(lblLogradouro);
		janela.add(tfLogradouro);

		JLabel lblComplemento = new JLabel("Complemento:");
		tfComplemento = new JTextField();
		lblComplemento.setBounds(10, 110, 100, 20);
		tfComplemento.setBounds(10, 130, 400, 20);
		janela.add(lblComplemento);
		janela.add(tfComplemento);

		JLabel lblBairro = new JLabel("Bairro:");
		tfBairro = new JTextField();
		lblBairro.setBounds(10, 160, 100, 20);
		tfBairro.setBounds(10, 180, 400, 20);
		janela.add(lblBairro);
		janela.add(tfBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		tfCidade = new JTextField();
		lblCidade.setBounds(10, 210, 100, 20);
		tfCidade.setBounds(10, 230, 400, 20);
		janela.add(lblCidade);
		janela.add(tfCidade);

		JLabel lblEstado = new JLabel("Estado:");
		tfEstado = new JTextField();
		lblEstado.setBounds(10, 260, 100, 20);
		tfEstado.setBounds(10, 280, 30, 20);
		janela.add(lblEstado);
		janela.add(tfEstado);

		JLabel lblUnidade = new JLabel("Unidade:");
		tfUnidade = new JTextField();
		lblUnidade.setBounds(80, 260, 100, 20);
		tfUnidade.setBounds(80, 280, 80, 20);
		janela.add(lblUnidade);
		janela.add(tfUnidade);

		JLabel lblIbge = new JLabel("IBGE:");
		tfIbge = new JTextField();
		lblIbge.setBounds(200, 260, 100, 20);
		tfIbge.setBounds(200, 280, 80, 20);
		janela.add(lblIbge);
		janela.add(tfIbge);

		JLabel lblGia = new JLabel("GIA:");
		tfGia = new JTextField();
		lblGia.setBounds(320, 260, 100, 20);
		tfGia.setBounds(320, 280, 80, 20);
		janela.add(lblGia);
		janela.add(tfGia);

		janela.setTitle("Busca CEP");
		janela.setVisible(true);
	}
	
	public void executaBusca() {
		String cep = tfCep.getText();
		if(cep.length()==8 && cep.indexOf("-")<0) {
			BuscaCEP bcep = new BuscaCEP(cep);
			bcep.pesquisa();
			tfLogradouro.setText(bcep.filtraPesquisa("logradouro"));
			tfComplemento.setText(bcep.filtraPesquisa("complemento"));
			tfBairro.setText(bcep.filtraPesquisa("bairro"));
			tfCidade.setText(bcep.filtraPesquisa("cidade"));
			tfEstado.setText(bcep.filtraPesquisa("estado"));
			tfUnidade.setText(bcep.filtraPesquisa("unidade"));
			tfIbge.setText(bcep.filtraPesquisa("ibge"));
			tfGia.setText(bcep.filtraPesquisa("gia"));
		}
	}
}
