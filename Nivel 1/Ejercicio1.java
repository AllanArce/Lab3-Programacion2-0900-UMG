public class Ejercicio1 {
    
    public static void main(String[] args) {
        try 
        {
            int division = 10/0;
            System.out.println("Intentado pasar: "+ division);
        } catch (ArithmeticException e) {

            // TODO: handle exception
            System.out.println("No se puede dividir dentro de 0.");
        } catch(Exception t)
        {
            System.out.println("Error General");
        } 

    }
}