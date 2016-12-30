class Main
{
    public static void main(String[] args)
    {
        String[] compliance = new String[50];
        for(int j = 1; j < 10 ; j++)
        {
            compliance[j] = "0%*";
            System.out.println(compliance[j]);

        }
        for(int j = 1; j < 10 ; j++)
        {
            if(compliance[j].equals("0%*")) {
                compliance[j] = "00%*";
                System.out.println(compliance[j]);
            }
        }
    }
}
