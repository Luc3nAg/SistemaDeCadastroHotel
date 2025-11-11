/*
 * Classe: Controler
 * Padrão aplicado: GRASP - Controller
 * 
 * Este arquivo centraliza a lógica de controle do sistema,
 * recebendo as solicitações (como cadastrar cliente, quarto, fazer reserva)
 * e coordenando as interações entre as classes de modelo (Cliente, Quarto, Reserva).
 */

package com.mycompany.sistemadecadastrohotel.control;

import com.mycompany.sistemadecadastrohotel.model.Cliente;
import com.mycompany.sistemadecadastrohotel.model.Reserva;
import com.mycompany.sistemadecadastrohotel.model.Quarto;
import java.util.ArrayList;
import java.util.List;

/*
 * Classe Controler
 * 
 * Essa classe implementa o papel de *Controller* no padrão GRASP.
 * No GRASP, o Controller é o "intermediário" entre a interface do usuário
 * 
 * Assim, a interface nunca fala diretamente com os objetos do modelo,
 * mantendo o sistema mais coeso e de baixo acoplamento.
 */
public class Controler {
    
    // Listas que armazenam os dados do sistema.
    // O Controller é responsável por gerenciar essas coleções, não a interface.
    private List<Cliente> clientes = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
            
    /*
     * Responsabilidade:
     * Cria e adiciona um novo objeto Cliente na lista.
     * 
     * Aplicação do GRASP:
     * - O Controller é responsável por orquestrar o cadastro (não a interface).
     * - O Controller usa o padrão GRASP "Creator", pois cria instâncias de objetos
     *   (Cliente) que ele próprio gerencia.
     */
    public void CadastrarCliente(String nome, String CPF, String Telefone){
        Cliente cliente = new Cliente(nome, CPF, Telefone);
        clientes.add(cliente);
        System.err.println("Cliente cadastrado com sucesso");
    }
    
    /*
     * Responsabilidade:
     * Cria um novo objeto Quarto e o adiciona na lista de quartos.
     * 
     * Aplicação do GRASP:
     * - O Controller atua como intermediário entre o modelo (Quarto)
     *   e qualquer interface (ex: menu, formulário).
     * - Aplica também o GRASP "Alta Coesão": este método realiza apenas
     *   o que está relacionado ao cadastro de quartos.
     */
    public void CadastrarQuarto(int numero, String tipo, double preco){
        Quarto quarto = new Quarto(numero, tipo, preco);
        quartos.add(quarto);
        System.out.println("Quarto cadastrado com sucesso");
    }

    /*
     * Método: FazerReserva
     * 
     * Responsabilidade:
     * Cria uma reserva associando um cliente e um quarto disponível.
     * 
     * Aplicação GRASP:
     * - O Controller é o ponto central que coordena as interações entre:
     *      Cliente → Quarto → Reserva
     * - Assim, a interface não precisa conhecer detalhes internos dessas classes.
     * - O método também aplica Alta Coesão (faz só o que diz: criar uma reserva)
     *   e mantém Baixo Acoplamento (nenhuma classe externa manipula diretamente
     *   as listas de clientes, quartos e reservas).
     */
    public void FazerReserva(int NumeroQuarto, String CPF, int Dias){
        // Busca o cliente pelo CPF usando stream
        Cliente cliente = clientes.stream().filter(c -> c.getCPF().equals(CPF)).findFirst().orElse(null);
        
        // Busca um quarto disponível (não ocupado)
        Quarto quarto = quartos.stream().filter(q -> q.getNumero() == NumeroQuarto && !q.isOcupado()).findFirst().orElse(null);   
        
        // Caso cliente e quarto existam, cria uma reserva
        if (cliente != null && quarto != null) {
            Reserva reserva = new Reserva(quarto, cliente, Dias);
            reservas.add(reserva);
            quarto.setOcupado(true);

            System.out.println("\n=== Reserva feita com sucesso ===");
            System.out.println(reserva);
        }else {
            // Feedback em caso de erro
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║  ERRO: Quarto ocupado ou não existe!   ║");
            System.out.println("╚════════════════════════════════════════╝");
        }
    }

    /*
     * Método: FazerCheckout
     * 
     * Responsabilidade:
     * Finaliza uma reserva existente e libera o quarto.
     * 
     * Aplicação GRASP:
     * - O Controller coordena as ações entre as entidades Reserva e Quarto.
     * - A lógica de checkout (buscar reserva, liberar quarto, remover da lista)
     *   está concentrada aqui, mantendo a interface livre de detalhes internos.
     */
    public void FazerCheckout(int NumeroQuarto) {
        // Localiza o quarto ocupado
        Quarto quarto = quartos.stream()
                .filter(q -> q.getNumero() == NumeroQuarto && q.isOcupado())
                .findFirst()
                .orElse(null);

        if(quarto != null) {
            // Localiza a reserva associada a esse quarto
            Reserva reserva = reservas.stream()
                    .filter(r -> r.getQuarto().getNumero() == NumeroQuarto)
                    .findFirst()
                    .orElse(null);

            if(reserva != null) {
                // Libera o quarto e remove a reserva da lista
                quarto.setOcupado(false);
                reservas.remove(reserva);

                System.out.println("\n=== CHECKOUT REALIZADO COM SUCESSO ===");
                System.out.println("Cliente: " + reserva.getHospede().getNome());
                System.out.println("Quarto: " + reserva.getQuarto().getNumero());
                System.out.println("Tipo: " + reserva.getQuarto().getTipo());
                System.out.println("Dias hospedado: " + reserva.getDias());
                System.out.println("Valor total: R$" + reserva.getValorTotal());
            }
        } else {
            System.out.println("Não existe reserva para este quarto ou ele já está desocupado.");
        }
    }
}
