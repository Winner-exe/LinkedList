public final class LinkedListDriver
{
    private static WinstonLeeLinkedList<String> groupAxioms;

    public static void main(String[] args)
    {
        groupAxioms = new WinstonLeeLinkedList<>();
        log("Initialization");

        //Addition of Elements
        groupAxioms.add("Closure: If a and b are in G, then ab is in G.");
        log("Add 'Closure'");
        groupAxioms.add("Identity: There exists an element e in G such that eg=g and ge=g.");
        log("Add 'Identity'");
        groupAxioms.addFirst("Let G be a group under multiplication.");
        log("Add First 'Assumption'");
        groupAxioms.add(2, "Associativity: (ab)c=a(bc) for all a,b,c in G.");
        log("Add Index 2 'Associativity'");
        groupAxioms.addLast("Inverses: If a is in G, then there exists an element i in G such that ai=e and ia=e.");
        log("Add Last 'Inverses'");

        //Setting
        System.out.println(groupAxioms.set(0, "Assumption: Let G be a group under multiplication."));
        log("Set 'Assumption'");

        //Size
        System.out.println(groupAxioms.size());
        log("Size Check");

        //Containment Checking
        System.out.println(groupAxioms.contains("Scalar Multiplication: If c is in F and v is in V, then cV is in V."));
        log("Contains 'Scalar Multiplication'");
        System.out.println(groupAxioms.contains("Identity: There exists an element e in G such that eg=g and ge=g."));
        log("Contains 'Identity'");

        //Retrieval
        System.out.println(groupAxioms.get(1));
        log("Retrieve index 1");
        System.out.println(groupAxioms.getFirst());
        log("Retrieve first");
        System.out.println(groupAxioms.getLast());
        log("Retrieve last");
        System.out.println(groupAxioms.indexOf("Associativity: (ab)c=a(bc) for all a,b,c in G."));
        log("Index of 'Associativity'");
        System.out.println(groupAxioms.indexOf("Additivity: f(a+b)=f(a)+f(b)."));
        log("Index of 'Additivity'");

        //Removal
        groupAxioms.addFirst("Abelian: ab=ba for all a,b in G.");
        log("Add First 'Abelian'");
        groupAxioms.add(2, "Distributive: c(v+w)=cv+cw and (c+d)v=cv+dv for all c,d in F and v,w in V.");
        log("Add Index 2 'Distributive'");
        groupAxioms.addFirst("Additive Abelian Group: G and the additive identity form an abelian group under addition.");
        log("Add First 'Additive Abelian Group'");
        groupAxioms.removeFirst();
        log("Remove First");
        groupAxioms.remove(2);
        log("Remove Index 2");
        groupAxioms.remove();
        log("Remove Head");

        //Clearing
        groupAxioms.clear();
        log("Clear");
    }

    private static void log(String operation)
    {
        System.out.println(operation);
        System.out.println("Group Axioms: ");
        groupAxioms.forEach(System.out::println);
        System.out.println("List Size: " + groupAxioms.size());
        System.out.println("---------------------------------------------------------------------------------------");
    }
}
