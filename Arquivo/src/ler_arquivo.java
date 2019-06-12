
public void ler_arquivo(){
    try{
        br = new BufferedReader(new FileReader("estadosARQ.txt"));
        Sring linha;
        while((linha = br.readLine())!=null)){
            System.out.println("linha");
        }
        br.close();
    }catch(Exception e ){};
    }