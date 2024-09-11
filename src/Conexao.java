import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexao {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String url = "jdbc:mysql://localhost:3306/Vl_Pinturas";
        String user = "root";
        String password = "euamoaheloa";

        try {

            Connection conexao = DriverManager.getConnection(url, user, password);

            //System.out.println("Você conectou-se ao banco de dados desejado com sucesso!");

            System.out.println("Olá, tudo bem?");

            System.out.println("Seja bem vindo ao VL_PINTURAS_SYSTEM!");
            for (int i = 1; i > 0; i++) {
                System.out.println("Escolha a opçao que desejas, digitando o número que a corresponde:");
                System.out.println("1- Clientes");
                System.out.println("2- Obras");
                System.out.println("3- gastos");
                System.out.println("4- Lucro");
                System.out.println("5- Orçamentos");
                System.out.println("6- Sair");

                System.out.println("Digite a opção desejada:");
                int escolha = Integer.parseInt(br.readLine());

                if (escolha == 1) {

                    for (int n = 1; n > 0; n++) {

                        System.out.println("1- Listar todos os clientes");
                        System.out.println("2- Buscar cliente");
                        System.out.println("3- Cadastrar cliente");
                        System.out.println("4- Atualizar cliente");
                        System.out.println("5- Deletar cliente");
                        System.out.println("6- Voltar");

                        System.out.println("Digite o número correspondente a opção desejada:");
                        int escolher = Integer.parseInt(br.readLine());

                        if (escolher == 1) {
                            Statement statement = conexao.createStatement();
                            String comando = "Select * from Clientes order by Nome;";

                            ResultSet resultado = statement.executeQuery(comando);
                            while (resultado.next()) {
                                System.out.println("Id_cliente:" + resultado.getString("Id_cliente") + " ");
                                System.out.println("Nome:" + resultado.getString("Nome"));
                                System.out.println("Telefone: " + resultado.getString("Telefone"));
                                System.out.println("Endereço: " + resultado.getString("Endereco"));
                            }
                        }
                        if (escolher == 2) {

                            System.out.println("Digite o nome ou parte do nome, do cliente que desejas procurar:");
                            String nomee = br.readLine();

                            String filtro = "Select * from Clientes where Nome like '%" + nomee + "%' ;";

                            Statement statement = conexao.createStatement();

                            ResultSet resultado = statement.executeQuery(filtro);
                            while (resultado.next()) {
                                System.out.println("Nome:" + resultado.getString("Nome"));
                                System.out.println("Telefone: " + resultado.getString("Telefone"));
                                System.out.println("Endereço: " + resultado.getString("Endereco"));
                            }
                        }
                        if (escolher == 3) {
                            System.out.println("Digite o nome do novo cliente:");
                            String novo_cliente = br.readLine();
                            System.out.println("Digite o Telefone do novo cliente:");
                            String novo_telefone = br.readLine();

                            System.out.println("Digite o endereço do novo cliente:");
                            String novo_endereco = br.readLine();

                            String inserir = "insert into Clientes (Nome,Telefone,Endereco) " +
                                    "values ('" + novo_cliente + "','" + novo_telefone + "','" + novo_endereco + "')";

                            Statement statement = conexao.createStatement();

                            statement.executeUpdate(inserir);

                            System.out.println("Cliente cadastrado com sucesso!");
                        }
                        if (escolher == 4) {
                            System.out.println("Digite o número correspondente a qual desejas atualizar:");
                            System.out.println("1- Nome");
                            System.out.println("2- Telefone");
                            System.out.println("3- Endereço");
                            System.out.println("4- Voltar");
                            int updat = Integer.parseInt(br.readLine());

                            if (updat == 1) {
                                System.out.println("Digite o codigo do cliente que deseja atualizar:");
                                int codiginn = Integer.parseInt(br.readLine());

                                System.out.println("Digite o novo nome:");
                                String Noome = br.readLine();

                                String updates = "UPDATE Clientes SET Nome = '" + Noome + "' WHERE Id_cliente = " + codiginn;

                                Statement statement = conexao.createStatement();

                                statement.executeUpdate(updates);

                                System.out.println("Nome do cliente atualizado com sucesso!");
                            }
                            if (updat == 2) {
                                System.out.println("Digite o codigo do cliente que deseja atualizar:");
                                int codiginnn = Integer.parseInt(br.readLine());

                                System.out.println("Digite o novo Telefone:");
                                String telefonne = br.readLine();

                                String updatess = "UPDATE Clientes SET Telefone = '" + telefonne + "' WHERE Id_cliente = " + codiginnn;

                                Statement statement = conexao.createStatement();

                                statement.executeUpdate(updatess);

                                System.out.println("Telefone do cliente atualizado com sucesso!");
                            }
                            if (updat == 3) {
                                System.out.println("Digite o codigo do cliente que deseja atualizar:");
                                int codiginn = Integer.parseInt(br.readLine());

                                System.out.println("Digite o novo Endereço:");
                                String Noome = br.readLine();

                                String updates = "UPDATE Clientes SET Endereco = '" + Noome + "' WHERE Id_cliente = " + codiginn;

                                Statement statement = conexao.createStatement();

                                statement.executeUpdate(updates);

                                System.out.println("Endereço do cliente atualizado com sucesso!");
                            }

                            if (updat == 4) {
                                break;
                            }
                            if (updat > 4) {
                                System.out.println("Digito insirido não corresponde a nenhuma opção, Tente novamente!");
                            }
                        }
                        if (escolher == 5) {
                            System.out.println("Digite o codigo do cliente que desejas deletar:");
                            int codigo = Integer.parseInt(br.readLine());

                            String updates = "DELETE from Clientes WHERE Id_cliente = " + codigo;

                            Statement statement = conexao.createStatement();

                            statement.executeUpdate(updates);

                            System.out.println("Cliente deletado com sucesso!");
                        }
                        if (escolher == 6) {
                            break;
                        }
                        if (escolher > 6) {
                            System.out.println("Digito insirido não corresponde a nenhuma opção, Tente novamente!");
                        }
                    }
                }
                if (escolha == 2) {
                    for (int nn = 1; nn > 0; nn++) {
                        System.out.println("1- Listar todas as obras:");
                        System.out.println("2- Buscar obra especifica:");
                        System.out.println("3- Cadastrar nova obra:");
                        System.out.println("4- Deletar obra");
                        System.out.println("5- voltar");
                        System.out.println("Digite o número correspondente a escoha desejada:");
                        int escolhaobra = Integer.parseInt(br.readLine());

                        if (escolhaobra == 1) {
                            String comandog1 = "select Id_obras, Nome, Descriçao as Descricao, Materiais from Obras join Clientes on Cliente_id = id_cliente;";

                            Statement statement = conexao.createStatement();

                            ResultSet resultado1 = statement.executeQuery(comandog1);
                            while (resultado1.next()) {
                                System.out.println("Id_obras:" + resultado1.getString("Id_obras"));
                                System.out.println("Nome: " + resultado1.getString("Nome"));
                                System.out.println("Descriçao:" + resultado1.getString("Descricao"));
                                System.out.println("Materiais:" + resultado1.getString("Materiais"));
                                System.out.println();
                            }
                        }
                        if (escolhaobra == 2) {

                            System.out.println("Digite o número da obra que deseja ver:");
                            int gasto = Integer.parseInt(br.readLine());

                            String comandog = "Select * from Obras where Id_obras = '" + gasto + "' ;";

                            Statement statement = conexao.createStatement();

                            ResultSet resultado1 = statement.executeQuery(comandog);
                            while (resultado1.next()) {
                                System.out.println("Id_obras:" + resultado1.getString("Id_obras"));
                                System.out.println("Cliente_id:" + resultado1.getString("Cliente_id"));
                                System.out.println("Gasto_id:" + resultado1.getString("Gasto_id"));
                                System.out.println("Lucro_id:" + resultado1.getString("Lucro_id"));
                                System.out.println("Descriçao:" + resultado1.getString("Descriçao"));
                                System.out.println("Materiais:" + resultado1.getString("Materiais"));
                            }
                        }
                        if (escolhaobra == 3) {
                            System.out.println("Digite o id do cliente:");
                            int idclienteobra = Integer.parseInt(br.readLine());

                            System.out.println("Digite o id do gasto:");
                            int idgastoobra = Integer.parseInt(br.readLine());

                            System.out.println("Digite o id do lucro:");
                            int idlucroobra = Integer.parseInt(br.readLine());

                            System.out.println("Digite a descriçao da obra:");
                            String descricao = br.readLine();

                            System.out.println("Digite os materiais da obra:");
                            String materiais = br.readLine();

                            String inserirg = "insert into Obras (Cliente_id,Gasto_id,Lucro_id,Descriçao,Materiais) " +
                                    "values (" + idclienteobra + "," + idgastoobra + "," + idlucroobra + ",'" + descricao + "','" + materiais + "')";

                            Statement statement = conexao.createStatement();

                            statement.executeUpdate(inserirg);

                            System.out.println("Obra cadastrado com sucesso!");

                        }
                        if (escolhaobra == 4) {

                            System.out.println("Digite o codigo da obra que desejas deletar:");
                            int codigo = Integer.parseInt(br.readLine());

                            String updates = "DELETE from Obras WHERE Id_obras = " + codigo;

                            Statement statement = conexao.createStatement();

                            statement.executeUpdate(updates);

                            System.out.println("obra deletada com sucesso!");
                        }
                        if (escolhaobra == 5) {
                            break;
                        }
                        if (escolhaobra > 5) {
                            System.out.println("Digito insirido não corresponde a nenhuma opção, Tente novamente!");
                        }
                    }
                }
                if (escolha == 3) {

                    for (int nn = 1; nn > 0; nn++) {
                        System.out.println("1- Listar todos os gastos:");
                        System.out.println("2- Buscar gasto de obra especifica:");
                        System.out.println("3- Cadastrar novo gasto:");
                        System.out.println("4- Deletar gasto");
                        System.out.println("5- voltar");
                        System.out.println("Digite o número correspondente a escoha desejada:");
                        int escolhagasto = Integer.parseInt(br.readLine());

                        if (escolhagasto == 1) {
                            String comandog1 = "Select * from Gastos;";

                            Statement statement = conexao.createStatement();

                            ResultSet resultado1 = statement.executeQuery(comandog1);
                            while (resultado1.next()) {
                                System.out.println("Id_gastos:" + resultado1.getString("Id_gastos"));
                                System.out.println("Cliente_id: " + resultado1.getString("Cliente_id"));
                                System.out.println("Gastos: R$" + resultado1.getString("Gasto"));
                            }
                        }
                        if (escolhagasto == 2) {

                            System.out.println("Digite o ID do gasto que desejas ver:");
                            int gastos = Integer.parseInt(br.readLine());

                            String comandoga = "Select * from Gastos where Id_gastos = " + gastos;

                            Statement statement = conexao.createStatement();

                            ResultSet resultado1 = statement.executeQuery(comandoga);
                            while (resultado1.next()) {
                                System.out.println("Id_gastos:" + resultado1.getString("Id_gastos"));
                                System.out.println("Cliente_id: " + resultado1.getString("Cliente_id"));
                                System.out.println("Gastos: R$" + resultado1.getString("Gasto"));
                            }
                        }
                        if (escolhagasto == 3) {
                            System.out.println("Digite o id do cliente:");
                            int idclientegasto = Integer.parseInt(br.readLine());

                            System.out.println("Digite o valor do gasto:");
                            double valorgasto = Double.parseDouble(br.readLine());

                            String inserirg = "insert into Gastos (Cliente_id,Gasto) " +
                                    "values ('" + idclientegasto + "','" + valorgasto + "')";

                            Statement statement = conexao.createStatement();

                            statement.executeUpdate(inserirg);

                            System.out.println("Gasto cadastrado com sucesso!");

                        }
                        if (escolhagasto == 4) {

                            System.out.println("Digite o codigo do gasto que desejas deletar:");
                            int codigo = Integer.parseInt(br.readLine());

                            String updates = "DELETE from Gastos WHERE Id_gastos = " + codigo;

                            Statement statement = conexao.createStatement();

                            statement.executeUpdate(updates);

                            System.out.println("Gasto deletado com sucesso!");
                        }
                        if (escolhagasto == 5) {
                            break;
                        }
                        if (escolhagasto > 5) {
                            System.out.println("Digito insirido não corresponde a nenhuma opção, Tente novamente!");
                        }
                    }
                }
                if (escolha == 4) {

                    for (int nn = 1; nn > 0; nn++) {
                        System.out.println("1- Listar todos os lucros:");
                        System.out.println("2- Buscar lucro de obra especifica:");
                        System.out.println("3- Cadastrar novo lucro:");
                        System.out.println("4- Deletar lucro");
                        System.out.println("5- voltar");
                        System.out.println("Digite o número correspondente a escoha desejada:");
                        int escolhalucro = Integer.parseInt(br.readLine());

                        if (escolhalucro == 1) {
                            String comandog1 = "Select * from Lucro;";

                            Statement statement = conexao.createStatement();

                            ResultSet resultado1 = statement.executeQuery(comandog1);
                            while (resultado1.next()) {
                                System.out.println("Id_lucro:" + resultado1.getString("Id_lucro"));
                                System.out.println("Gasto_id: " + resultado1.getString("Gasto_id"));
                                System.out.println("Lucro: R$" + resultado1.getString("lucro"));
                            }
                        }
                        if (escolhalucro == 2) {

                            System.out.println("Digite o número da obra que deseja ver os lucros:");
                            int lucro = Integer.parseInt(br.readLine());

                            String comandog = "Select * from Lucro where Id_lucro = '" + lucro + "' ;";

                            Statement statement = conexao.createStatement();

                            ResultSet resultado1 = statement.executeQuery(comandog);
                            while (resultado1.next()) {
                                System.out.println("Id_lucro:" + resultado1.getString("Id_lucro"));
                                System.out.println("Gasto_id: " + resultado1.getString("Gasto_id"));
                                System.out.println("Lucro: R$" + resultado1.getString("lucro"));
                            }
                        }
                        if (escolhalucro == 3) {
                            System.out.println("Digite o id do gasto:");
                            int idlucro = Integer.parseInt(br.readLine());

                            System.out.println("Digite o valor do lucro:");
                            double valorlucro = Double.parseDouble(br.readLine());

                            String inserirg = "insert into Lucro (Gasto_id,lucro) " +
                                    "values ('" + idlucro + "','" + valorlucro + "')";

                            Statement statement = conexao.createStatement();

                            statement.executeUpdate(inserirg);

                            System.out.println("Lucro cadastrado com sucesso!");

                        }
                        if (escolhalucro == 4) {

                            System.out.println("Digite o codigo do lucro que desejas deletar:");
                            int codigo = Integer.parseInt(br.readLine());

                            String updates = "DELETE from Lucro WHERE Id_lucro = " + codigo;

                            Statement statement = conexao.createStatement();

                            statement.executeUpdate(updates);

                            System.out.println("lucro deletado com sucesso!");
                        }
                        if (escolhalucro == 5) {
                            break;
                        }
                        if (escolhalucro > 5) {
                            System.out.println("Digito insirido não corresponde a nenhuma opção, Tente novamente!");
                        }
                    }
                }
                if (escolha == 5) {
                    for (int n = 1; n > 0; n++) {
                        System.out.println("Digite o número correspondente a opção desejada:");
                        System.out.println("1- Consultar orçamentos");
                        System.out.println("2- Fazer novo orçamento");
                        System.out.println("3- Calcular metros quadrados");
                        System.out.println("4- Voltar");
                        int escolhaaa = Integer.parseInt(br.readLine());

                        if (escolhaaa == 1) {
                            for (int l = 1; l > 0; l++) {
                                System.out.println("Digite o número correspondente a qual tipo de orçamento desejas consultar:");
                                System.out.println("1- Orçamentos de pinturas");
                                System.out.println("2- Orçamentos de preparações");
                                System.out.println("3- Orçamentos de ambos");
                                System.out.println("4- Voltar");
                                int escolhaaaaaaa = Integer.parseInt(br.readLine());

                                if (escolhaaaaaaa == 1) {
                                    String comando = "Select * from orcamento_pinturas;";

                                    Statement statement = conexao.createStatement();

                                    ResultSet resultado1 = statement.executeQuery(comando);

                                    while (resultado1.next()) {
                                        System.out.println("Pintura id: " + resultado1.getString("pintura_id"));
                                        System.out.println("Metros Quadrados: " + resultado1.getString("metros_quadrados"));
                                        System.out.println("Valor por m2: R$" + resultado1.getString("Preco_m2"));
                                        System.out.println("Valor total: R$" + resultado1.getString("Total"));
                                    }
                                }
                                if (escolhaaaaaaa == 2) {
                                    String comandos = "Select * from orcamento_preparacao;";

                                    Statement statementt = conexao.createStatement();

                                    ResultSet resultadoo = statementt.executeQuery(comandos);
                                    while (resultadoo.next()) {
                                        System.out.println("Preparação id: " + resultadoo.getString("preparacao_id"));
                                        System.out.println("Metros Quadrados: " + resultadoo.getString("metros2"));
                                        System.out.println("Preço por m2: R$" + resultadoo.getString("Precos_mq2"));
                                        System.out.println("Valor total: R$" + resultadoo.getString("Totall"));
                                    }
                                }
                                if (escolhaaaaaaa == 3) {
                                    String codigo = "select * from orcamento_ambos;";

                                    Statement s = conexao.createStatement();

                                    ResultSet resultado = s.executeQuery(codigo);
                                    while (resultado.next()) {
                                        System.out.println("Ambos id: " + resultado.getString("ambos_id"));
                                        System.out.println("Metros Quadrados: " + resultado.getString("metros2"));
                                        System.out.println("Preço por m2: R$" + resultado.getString("Precos_mq2"));
                                        System.out.println("Valor total: R$" + resultado.getString("Totall"));
                                    }
                                }
                                if (escolhaaaaaaa >= 4) {
                                    break;
                                }
                            }
                        }
                        if (escolhaaa == 2) {
                            for (int iii = 1; iii > 0; iii++) {
                                System.out.println("Digite o número correspondente ao tipo de trabalho que desejas orçar:");
                                System.out.println("1- Pintura");
                                System.out.println("2- Preparação");
                                System.out.println("3- Ambos");
                                System.out.println("4- Voltar");
                                int escolhaorcar = Integer.parseInt(br.readLine());

                                if (escolhaorcar == 1) {
                                    int valor_pinturas = 14;
                                    System.out.println("Valor da pintura por m2: R$" + valor_pinturas);

                                    System.out.println("Digite o tamanho em metros quadrados para realizar o orçamento:");
                                    double metros2 = Double.parseDouble(br.readLine());

                                    double valor_orcamento_pinturas = metros2 * valor_pinturas;

                                    System.out.println("Valor total do orçamento: R$" + valor_orcamento_pinturas);

                                    String inserirg = "insert into orcamento_pinturas (metros_quadrados,Preco_m2,Total) " +
                                            "values ('" + metros2 + "','" + valor_pinturas + "','" + valor_orcamento_pinturas + "')";

                                    Statement statement = conexao.createStatement();

                                    statement.executeUpdate(inserirg);

                                    System.out.println("Orçamento criado com exito!");
                                }
                                if (escolhaorcar == 2) {
                                    int valor_preparacao = 16;
                                    System.out.println("Valor da pintura por m2: R$" + valor_preparacao);

                                    System.out.println("Digite o tamanho em metros quadrados para realizar o orçamento:");
                                    double metros2 = Double.parseDouble(br.readLine());

                                    double valor_orcamento_preparacao = metros2 * valor_preparacao;

                                    System.out.println("Valor total do orçamento: R$" + valor_orcamento_preparacao);

                                    String inserirg = "insert into orcamento_preparacao (metros2,Precos_mq2,Totall) " +
                                            "values ('" + metros2 + "','" + valor_preparacao + "','" + valor_orcamento_preparacao + "')";

                                    Statement statement = conexao.createStatement();

                                    statement.executeUpdate(inserirg);

                                    System.out.println("Orçamento criado com exito!");
                                }
                                if (escolhaorcar == 3) {
                                    double valor_ambos = 27.5;
                                    System.out.println("Valor da pintura por m2: R$" + valor_ambos);

                                    System.out.println("Digite o tamanho em metros quadrados para realizar o orçamento:");
                                    double metros2 = Double.parseDouble(br.readLine());

                                    double valor_orcamento_ambos = metros2 * valor_ambos;

                                    System.out.println("Valor total do orçamento: R$" + valor_orcamento_ambos);

                                    String inserirg = "insert into orcamento_ambos (metros2,Precos_mq2,Totall) " +
                                            "values ('" + metros2 + "','" + valor_ambos + "','" + valor_orcamento_ambos + "')";

                                    Statement statement = conexao.createStatement();

                                    statement.executeUpdate(inserirg);

                                    System.out.println("Orçamento criado com exito!");
                                }
                                if (escolhaorcar >= 4) {
                                    break;
                                }
                            }
                        }
                        if (escolhaaa == 3) {
                            for (int t = 1; t > 0; t++) {

                                System.out.println("Digite a altura em metros:");
                                double altura = Double.parseDouble(br.readLine());

                                System.out.println("Digite a largura em metros:");
                                double largura = Double.parseDouble(br.readLine());

                                double totalm2 = altura * largura;
                                double armazenar = totalm2;
                                double total_final = armazenar + totalm2;


                                System.out.println("Total : " + totalm2 + "m2");

                                System.out.println("Digite a opção desejada:");
                                System.out.println("1- Continuar calculando");
                                System.out.println("2- Simular orçamento");
                                System.out.println("3- Descontar metragem");
                                System.out.println("4- Voltar ao menu anterior");

                                int escolher = Integer.parseInt(br.readLine());

                                if (escolher == 1) {
                                    continue;
                                }
                                if (escolher == 2) {
                                    System.out.println("Digite o número que corresponde ao que desejas simular:");
                                    System.out.println("1- Pintura");
                                    System.out.println("2- Preparação");
                                    System.out.println("3- Ambos");
                                    System.out.println("4- Voltar ao menu anterior");
                                    System.out.println("5- Sair");
                                    int ecolha = Integer.parseInt(br.readLine());

                                    if (ecolha == 1) {
                                        int valor_pintura = 14;
                                        System.out.println("Valor da pintura por m2: R$" + valor_pintura);

                                        double valor_simulacao_pintura = total_final * valor_pintura;

                                        System.out.println("Valor total da simulação: R$" + valor_simulacao_pintura);
                                    }
                                    if (ecolha == 2) {
                                        int valor_preparacao = 16;
                                        System.out.println("Valor da preparação por m2: R$" + valor_preparacao);

                                        double valor_simulacao_pintura = total_final * valor_preparacao;

                                        System.out.println("Valor total da simulação: R$" + valor_simulacao_pintura);
                                    }
                                    if (ecolha == 3) {
                                        double valor_ambos = 27.5;
                                        System.out.println("Valor de ambos por m2: R$" + valor_ambos);

                                        double valor_simulacao_pintura = total_final * valor_ambos;

                                        System.out.println("Valor total da simulação: R$" + valor_simulacao_pintura);
                                    }
                                    if (ecolha == 4) {
                                        continue;
                                    }
                                    if (ecolha >= 5) {
                                        break;
                                    }
                                }
                                if (escolher == 3) {
                                    System.out.println("Digite o número a opção que desejas descontar:");
                                    System.out.println("1- Porta");
                                    System.out.println("2- Janela");
                                    System.out.println("3- Especifico");
                                    System.out.println("4- Voltar ao menu");

                                    int escolhaaaa = Integer.parseInt(br.readLine());

                                    if (escolhaaaa == 1) {
                                        totalm2 = totalm2 - 2;
                                        System.out.println("Total com desconto da porta: " + totalm2 + "m2");
                                    }
                                    if (escolhaaaa == 2) {
                                        totalm2 = totalm2 - 1.2;
                                        System.out.println("Total com desconto da janela: " + totalm2 + "m2");
                                    }
                                    if (escolhaaaa == 3) {
                                        System.out.println("Digite em m2 quanto desejas descontar:");
                                        double descontom2 = Double.parseDouble(br.readLine());
                                        totalm2 = totalm2 - descontom2;
                                        System.out.println("Total com desconto: " + totalm2 + "m2");
                                    }
                                    if (escolhaaaa >= 4) {
                                        break;
                                    }
                                }
                                if (escolher >= 4) {
                                    System.out.println("Total final = " + total_final + "m2");
                                    break;
                                }
                            }
                        }
                        if (escolhaaa >= 4) {
                            break;
                        }
                    }
                }
                if (escolha == 6) {
                    System.out.println("Obrigado e até a procima!");
                    break;
                }
                if (escolha > 6) {
                    System.out.println("Digito insirido não corresponde a nenhuma opção, Tente novamente!");
                }
            }
        } catch (SQLException erro) {
            System.out.println("Ocorrreu o seguinte erro : " + erro.getMessage() + " !");
        }
    }
}




