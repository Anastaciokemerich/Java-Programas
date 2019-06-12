
import javax.swing.JOptionPane;


public class Tabuleiro {
    
    char matriz[][] = new char[3][3];
    
    public Tabuleiro(){
        inicializarMatriz();
    }
    
    public void inicializarMatriz(){
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                matriz[linha][coluna] = '?';               
            }
        }
    }
    
    public void exibirMatriz(){
        System.out.println(matriz[0][0] + " | " + matriz[0][1] + " | " + matriz[0][2]);               
        System.out.println(matriz[1][0] + " | " + matriz[1][1] + " | " + matriz[1][2]);
        System.out.println(matriz[2][0] + " | " + matriz[2][1] + " | " + matriz[2][2]); 
        System.out.println("");
    }
    
    public String podeJogar(int linha, int coluna) {
        String resposta = "";
        
        if (matriz[linha][coluna] == '?') {
            resposta = "Sim" ;            
        }
        
        else if (matriz[linha][coluna] == 'X') {
            resposta = "Não" ;            
        }
        
        
        else if (matriz[linha][coluna] == 'O') {
            resposta = "Não";   
        }
        
 
        return resposta;
    }
    
    public void realizarJogada(int linha, int coluna, char simbolo) {
        matriz[linha][coluna] = simbolo;
    }
    
    
    public boolean testarGanhador(){
        boolean continuaJogo = true;
        if (matriz[0][0] == 'X' && matriz[0][1] == 'X' && matriz[0][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Pessoa venceu...");
            return false;
        }
        else if (matriz[0][0] == 'O' && matriz[0][1] == 'O' && matriz[0][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computador venceu...");
            return false;
            
        }
        else if (matriz[1][0] == 'X' && matriz[1][1] == 'X' && matriz[1][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Pessoa venceu...");
            return false;   
        }
        else if (matriz[1][0] == 'O' && matriz[1][1] == 'O' && matriz[1][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computador venceu...");
            return false;
        }
        else if (matriz[2][0] == 'X' && matriz[2][1] == 'X' && matriz[2][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Pessoa venceu...");
            return false;   
        }
        else if (matriz[2][0] == 'O' && matriz[2][1] == 'O' && matriz[2][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computador venceu...");
            return false;
        }
        else if (matriz[0][0] == 'X' && matriz[1][0] == 'X' && matriz[2][0] == 'X') {
            JOptionPane.showMessageDialog(null, "Pessoa venceu...");
            return false;   
        }
        else if (matriz[0][0] == 'O' && matriz[1][0] == 'O' && matriz[2][0] == 'O') {
            JOptionPane.showMessageDialog(null, "Computador venceu...");
            return false;
        }
        else if (matriz[0][1] == 'X' && matriz[1][1] == 'X' && matriz[2][1] == 'X') {
            JOptionPane.showMessageDialog(null, "Pessoa venceu...");
            return false;   
        }
        else if (matriz[0][1] == 'O' && matriz[1][1] == 'O' && matriz[2][1] == 'O') {
            JOptionPane.showMessageDialog(null, "Computador venceu...");
            return false;
        }
        else if (matriz[0][2] == 'X' && matriz[1][2] == 'X' && matriz[2][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Pessoa venceu...");
            return false;   
        }
        else if (matriz[0][2] == 'O' && matriz[1][2] == 'O' && matriz[2][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computador venceu...");
            return false;
        }
        else if (matriz[0][0] == 'X' && matriz[1][1] == 'X' && matriz[2][2] == 'X') {
            JOptionPane.showMessageDialog(null, "Pessoa venceu...");
            return false;   
        }
        else if (matriz[0][0] == 'O' && matriz[1][1] == 'O' && matriz[2][2] == 'O') {
            JOptionPane.showMessageDialog(null, "Computador venceu...");
            return false;
        }
        else if (matriz[0][2] == 'X' && matriz[1][1] == 'X' && matriz[2][0] == 'X') {
            JOptionPane.showMessageDialog(null, "Pessoa venceu...");
            return false;   
        }
        else if (matriz[0][2] == 'O' && matriz[1][1] == 'O' && matriz[2][0] == 'O') {
            JOptionPane.showMessageDialog(null, "Computador venceu...");
            return false;
        }

        
        return continuaJogo;
        
    }
    
    
    // verifica se na primeira jogada, a posição do meio está livre.
    // Ou seja, caso a pessoa tenha dado sopa na primeira jogada, o computador ignora a geração
    // aleatória de posicao(linha,coluna) e efetua a jogada no meio para aumetar as chances.
    public String posicaoDoMeioEstaLivre() {
        String resposta="";
        if (matriz[1][1] == '?'){
            resposta = "Sim";
        }
        else {
            resposta = "Não";
        }
        return resposta;    
    }
    
    // caso a posicao do meio esteja ocupada, iniciar o jogo numa das pontas, para evitar de perder caso a
    // aleatoriedade da jogada escolhesse uma posicao de meio.
    public String posicaoDaPonta() {
        String resposta="";
        if (matriz[0][0] == '?'){
            resposta = "Sim";
        }
        else {
            resposta = "Não";
        }
        return resposta;    
    }
    
    // metodo recebepor parâmetro, primeiro o símbolo O (computador) para procurar bolinhas próximas e tentar ganhar se tiver a possibilidade
    // na segunda chamada do método, é passado por parâmetro o símbolo X (pessoa) para procurar X próximos e bloquear, já que não foi possível
    // ganhar na chamada anterior. Ou seja, primeiro eu (computador) tento ganhar, caso não seja possível, tento me defender.
    public int[] verificarPosicaoDeAtaqueEDefesa(char simbolo){ // 
        int vet[] = new int[2];
        vet[0]=9; // 9 é valor qualquer para dizer que foi encontrado nem um valor entre 0 e 2 para linha
        vet[1]=9; // 9 é valor qualquer para dizer que foi encontrado nem um valor entre 0 e 2 para coluna
        
        
        //testa jogadas vencedoras nas linhas
        if(matriz[0][0]==simbolo && matriz[0][1]==simbolo && matriz[0][2]=='?') {
            vet[0]=0;
            vet[1]=2;
        }
        else if(matriz[0][0]==simbolo && matriz[0][1]=='?' && matriz[0][2]==simbolo){
            vet[0]=0;
            vet[1]=1;
        }
        else if(matriz[0][0]=='?' && matriz[0][1]==simbolo && matriz[0][2]==simbolo){
            vet[0]=0;
            vet[1]=0;
        }
        
        else if(matriz[1][0]==simbolo && matriz[1][1]==simbolo && matriz[1][2]=='?') {
            vet[0]=1;
            vet[1]=2;
        }
        else if(matriz[1][0]==simbolo && matriz[1][1]=='?' && matriz[1][2]==simbolo){
            vet[0]=1;
            vet[1]=1;
        }
        else if(matriz[1][0]=='?' && matriz[1][1]==simbolo && matriz[1][2]==simbolo){
            vet[0]=1;
            vet[1]=0;
        }
        
        else if(matriz[2][0]==simbolo && matriz[2][1]==simbolo && matriz[2][2]=='?') {
            vet[0]=2;
            vet[1]=2;
        }
        else if(matriz[2][0]==simbolo && matriz[2][1]=='?' && matriz[2][2]==simbolo){
            vet[0]=2;
            vet[1]=1;
        }
        else if(matriz[2][0]=='?' && matriz[2][1]==simbolo && matriz[2][2]==simbolo){
            vet[0]=2;
            vet[1]=0;
        }
        
        //testa jogadas vencedoras nas colunas
        else if(matriz[0][0]==simbolo && matriz[1][0]==simbolo && matriz[2][0]=='?') {
            vet[0]=2;
            vet[1]=0;
        }
        else if(matriz[1][0]==simbolo && matriz[2][0]==simbolo && matriz[0][0]=='?'){
            vet[0]=0;
            vet[1]=0;
        }
        else if(matriz[0][0]==simbolo && matriz[1][0]=='?' && matriz[2][0]==simbolo){
            vet[0]=1;
            vet[1]=0;
        }
        
        else if(matriz[0][1]==simbolo && matriz[1][1]==simbolo && matriz[2][1]=='?') {
            vet[0]=2;
            vet[1]=1;
        }
        else if(matriz[0][1]==simbolo && matriz[2][1]==simbolo && matriz[1][1]=='?'){
            vet[0]=1;
            vet[1]=1;
        }
        else if(matriz[1][1]==simbolo && matriz[2][1]==simbolo && matriz[0][1]=='?'){
            vet[0]=0;
            vet[1]=1;
        }
        
        else if(matriz[0][2]==simbolo && matriz[1][2]==simbolo && matriz[2][2]=='?') {
            vet[0]=2;
            vet[1]=2;
        }
        else if(matriz[1][2]==simbolo && matriz[2][2]==simbolo && matriz[0][2]=='?'){
            vet[0]=0;
            vet[1]=2;
        }
        else if(matriz[0][2]==simbolo && matriz[2][2]==simbolo && matriz[1][2]=='?'){
            vet[0]=1;
            vet[1]=2;
        }
        
        // testar jogadas vencedoras nas diagonais
        else if(matriz[0][0]==simbolo && matriz[1][1]==simbolo && matriz[2][2]=='?') {
            vet[0]=2;
            vet[1]=2;
        }
        else if(matriz[1][1]==simbolo && matriz[2][2]==simbolo && matriz[0][0]=='?'){
            vet[0]=0;
            vet[1]=0;
        }
        else if(matriz[0][0]==simbolo && matriz[2][2]==simbolo && matriz[1][1]=='?'){
            vet[0]=1;
            vet[1]=1;
        }
        
        else if(matriz[0][2]==simbolo && matriz[1][1]==simbolo && matriz[2][0]=='?') {
            vet[0]=2;
            vet[1]=0;
        }
        else if(matriz[1][1]==simbolo && matriz[2][0]==simbolo && matriz[0][2]=='?'){
            vet[0]=0;
            vet[1]=2;
        }
        else if(matriz[0][2]==simbolo && matriz[2][0]==simbolo && matriz[1][1]=='?'){
            vet[0]=1;
            vet[1]=1;
        }

        return vet;
    } 
    
    
    
}
            

