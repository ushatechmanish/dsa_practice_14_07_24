package in.ushatech.dsa;

public class InnerInnerClassTest {
    public static void main(String[] args) {
        I obj = new IImpl(); // code to interface

        IImpl objNew = new IImpl();

        I objAnonymous = new I() {
            public String capitalizeName(String name)
            {
                return name.toUpperCase();
            }
        };

        // I objAnonymous1 = new I();

        I lambdaImpl = (name)-> name.toUpperCase();

        I innerImpl = new InnerInnerClassTest().new IInner();

        I innerStaticClass = new IInnerStatic();
        
    }

    class IInner implements I 
    {
        public String capitalizeName(String name)
        {
            return null;
        }
    }
    static class IInnerStatic implements I 
    {
        public String capitalizeName(String name)
        {
            return null;
        }
    }
}

