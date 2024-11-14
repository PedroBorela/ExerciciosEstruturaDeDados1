import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;

public class Exercicio3 extends JFrame {
    public JButton jb1;
    public JTextField jt;
    public JLabel jl;
    public String[] listaConvidados;
    public JButton botoesExcluir;
    public GridBagLayout layout;
    public GridBagConstraints constr;
    public JMenuBar menuBarra;
    public JMenu menu;
    public JMenuItem visu;
    public int index = 0;
    public JLabel err;
    public JMenuItem adicionar;
    public JMenuItem deletar;
    public JMenuItem listar;
    public JLabel mostraLista;
    public JLabel vagas;
    private int ultimaPosicao = -1;
    private JButton botaoAnterior;
    private JButton botaoProximo;

   

    public Exercicio3() {
        super("Exercício 3");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        layout = new GridBagLayout();
        constr = new GridBagConstraints();
        setLayout(layout);

        jb1 = new JButton("Adicionar");
        jb1.setBackground(Color.green);
        jt = new JTextField(20);
        jl = new JLabel("Lista de convidados");
        listaConvidados = new String[10];
        botoesExcluir = new JButton();
        botaoAnterior = new JButton("<");
        botaoProximo = new JButton(">");
        mostraLista = new JLabel();
        vagas = new JLabel("A quantidade de vagas restantes é: 10");

        menuBarra = new JMenuBar();
        menu = new JMenu("Ações");
        visu = new JMenuItem("Visualizar lista");
        deletar = new JMenuItem("Apagar convidado da lista");
        botoesExcluir = new JButton("Excluir");
        adicionar = new JMenuItem("adicionar");
        err = new JLabel();
        menu.add(visu);
        menu.add(adicionar);
        menu.add(deletar);
        menuBarra.add(menu);
        setJMenuBar(menuBarra);

        constr.anchor = GridBagConstraints.CENTER;
        constr.fill = GridBagConstraints.BOTH;
        constr.weightx = 1;
        constr.insets = new Insets(3, 3, 3, 3);

        botoesExcluir.setForeground(Color.white);
        botoesExcluir.setBackground(Color.RED);
        botoesExcluir.addActionListener(new Hand());
        botoesExcluir.setEnabled(false);
        botaoAnterior.setEnabled(false);
        botaoProximo.setEnabled(false);
        addComponent(jl, 0, 0, 1, 6);
        addComponent(jt, 1, 0, 1, 6);

        addComponent(botaoAnterior, 2, 0, 1, 1);
        addComponent(jb1, 2, 1, 1, 2);
        addComponent(botoesExcluir, 2, 3, 1, 2);
        addComponent(botaoProximo, 2, 5, 1, 1);

        addComponent(mostraLista, 3, 0, 1, 6);
        addComponent(vagas, 6, 0, 1, 6);
        addComponent(err, 13, 0, 1, 2);

        mostraLista.setVisible(false);

        Hand hd = new Hand();
        jb1.addActionListener(hd);
        visu.addActionListener(hd);
        botaoAnterior.addActionListener(hd);
        botaoProximo.addActionListener(hd);
        adicionar.addActionListener(hd);
        deletar.addActionListener(hd);

        setVisible(true);
    }

    private void addComponent(Component c, int x, int y, int row, int col) {
        constr.gridx = y;
        constr.gridy = x;
        constr.gridwidth = col;
        constr.gridheight = row;
        layout.setConstraints(c, constr);
        add(c);
    }

    private class Hand implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jb1) {
                try {
                    if (!jt.getText().equals(""))
                        insereFinal(listaConvidados, jt.getText());
                    else
                        JOptionPane.showMessageDialog(null, "Adicione alguem na lista");
                    jt.setText("");
                    System.out.println(ultimaPosicao);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    err.setText("A lista de convidados está cheia");
                    revalidate();
                    jb1.setEnabled(false);
                }
            }

            if (e.getSource() == botoesExcluir) {
                try {
                    excluiFinal(listaConvidados);
                } catch (Exception eaa) {
                    System.out.println("A lista está vazia");
                    err.setText("A lista de convidados está vazia");
                    botoesExcluir.setEnabled(false);

                }
            }

            if (e.getSource() == visu) {
                mostraLista.setVisible(true);
            }

            if (e.getSource() == deletar) {
                botaoAnterior.setEnabled(true);
                botaoProximo.setEnabled(true);
                jb1.setEnabled(false);
                jt.setEnabled(false);
                botoesExcluir.setEnabled(true);
                jt.setText(listaConvidados[0]);
            }
            if (e.getSource() == botaoAnterior) {
                if (index != 0) {
                    index--;
                    jt.setText(listaConvidados[index]);
                }
            }

            if (e.getSource() == adicionar) {
                if (index != listaConvidados.length - 1) {
                    jt.setEnabled(true);
                    botaoAnterior.setEnabled(false);
                    botaoProximo.setEnabled(false);
                    botoesExcluir.setEnabled(false);
                    jb1.setEnabled(true);
                    jt.setText("");
                }
            }
            if (e.getSource() == botaoProximo) {
                if (index != ultimaPosicao) {
                    index++;
                    jt.setText(listaConvidados[index]);
                }
            }
        }

    }

    private void insereFinal(String[] vet, String elemento) throws Exception {
        if (ultimaPosicao >= vet.length - 1)
            throw new Exception("A lista de convidados ta cheio");
        ++ultimaPosicao;
        vet[ultimaPosicao] = elemento;
        vagas.setText("A quantidade de vagas restantes é: " + (9 - ultimaPosicao));
        err.setText("");

        mostraLista.setText(mostraLista.getText() + " " + elemento);

        revalidate();
    }

    private void excluiFinal(String[] vet) throws Exception {
        if (ultimaPosicao == -1)
            throw new Exception("A lista está vazia");

        for (int i = index; i < ultimaPosicao; i++) {
            System.out.println(ultimaPosicao);
            vet[i] = vet[i + 1];
            System.out.println(vet[i]);

        }

        vet[ultimaPosicao] = "";
        // labelsConvidados[ultimaPosicao] = null;
        mostraLista.setText("");
        index = 0;
        jt.setText(listaConvidados[index]);
        for (int i = 0; i <= ultimaPosicao; i++) {
            mostraLista.setText(mostraLista.getText() + vet[i] + " ");
            // vagas.setText("A quantidade de vagas é de: "+(9-i));
            err.setText("");
            vagas.setText("A quantidade de vagas é de: " + (10 - ultimaPosicao));
        }

        --ultimaPosicao;
        revalidate();

    }


    public static void main(String[] args) {
        new Exercicio3();

    }
}
