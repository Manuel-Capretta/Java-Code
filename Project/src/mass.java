public class mass{
    int Units = 5;

    public Unit meters[] = new Unit[Units];
    public Unit liquids[] = new Unit[Units];

    Unit mm = new Unit("mm", 1);
    Unit cm = new Unit("cm", 10);
    Unit dm = new Unit("dm", 100);
    Unit m = new Unit("m", 1000);
    Unit km = new Unit("km", 1000000);

    Unit ml = new Unit("mm", 1);
    Unit cl = new Unit("cm", 10);
    Unit dl = new Unit("dm", 100);
    Unit l = new Unit("m", 1000);
    Unit hl = new Unit("km", 100000);

    public void arrayDeclarations(){
        //put units into masses array
        meters[0] = mm;
        meters[1] = cm;
        meters[2] = dm;
        meters[3] = m;
        meters[4] = km;
        liquids[0] = ml;
        liquids[1] = cl;
        liquids[2] = dl;
        liquids[3] = l;
        liquids[4] = hl;
    }
}
