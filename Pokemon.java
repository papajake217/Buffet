package Buffet;

public class Pokemon {
    public double hp;
    public double maxHp;
    public String name;
    public Move[] moves = new Move[4];
    public String type;

    public Pokemon(String name,double hp, String type, String move1, String move1Type,double move1Dmg,String move2, String move2Type,double move2Dmg,String move3, String move3Type,double move3Dmg,String move4, String move4Type,double move4Dmg){
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.type = type;
        this.moves[0] = new Move(move1,move1Type,move1Dmg);
        this.moves[1] = new Move(move2,move2Type,move2Dmg);
        this.moves[2] = new Move(move3,move3Type,move3Dmg);
        this.moves[3] = new Move(move4,move4Type,move4Dmg);
    }

    public void attack(Move move, Pokemon enemy){
        double multiplier = effectiveMultiplier(move.type,enemy.type);
        double damage = multiplier * move.dmg;
        enemy.hp -= damage;
    }

    //18 types stored in a list of Strings to tell whats effective
    //This will work by using the chart corresponding to the type and then finding the index of the type of the pokemon being attacked, then going to that index in the corresponding list of effectiveness
    String[] typeChart = {"Normal","Fire","Water","Electric","Grass","Ice","Fighting","Poison","Ground","Flying","Psychic","Bug","Rock","Ghost","Dragon","Dark","Steel","Fairy"};



    double[] dmgList = {};


    //charts depicting the multiplier to the damage which corresponds to a chart with the type chart as the x and y axes

    double[][] effectivenessChart =
                    {
                            {1,1,1,1,1,1,1,1,1,1,1,1,0.5,0,1,1,0.5,1},
                            {1,0.5,0.5,1,2,2,1,1,1,1,1,2,0.5,1,0.5,1,2,1},
                            {1,2,0.5,1,0.5,1,1,1,2,1,1,1,2,1,0.5,1,2,1},
                            {1,1,2,0.5,0.5,1,1,1,2,1,1,1,2,1,0.5,1,1,1},
                            {1,0.5,2,1,0.5,1,1,0.5,2,0.5,1,0.5,2,1,0.5,1,0.5,1},
                            {1,0.5,0.5,1,2,0.5,1,1,2,2,1,1,1,1,2,1,0.5,1},
                            {2,1,1,1,1,2,1,0.5,1,0.5,0.5,0.5,2,0,1,2,2,0.5},
                            {1,1,1,1,2,1,1,0.5,0.5,1,1,1,0.5,0.5,1,1,0,2},
                            {1,2,1,2,0.5,1,1,2,1,0,1,0.5,2,1,1,1,2,1},
                            {1,1,1,0.5,2,1,2,1,1,1,1,2,0.5,1,1,1,0.5,1},
                            {1,1,1,1,1,1,2,2,1,1,0.5,1,1,1,1,0,0.5,1},
                            {1,0.5,1,1,2,1,0.5,0.5,1,0.5,2,1,1,0.5,1,2,0.5,0.5},
                            {1,2,1,1,1,2,0.5,1,0.5,2,1,2,1,1,1,1,0.5,1},
                            {0,1,1,1,1,1,1,1,1,1,2,1,1,2,1,0.5,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,0.5,0},
                            {1,1,1,1,1,1,0.5,1,1,1,2,1,1,2,1,0.5,1,0.5},
                            {1,0.5,0.5,0.5,1,2,1,1,1,1,1,1,2,1,1,1,0.5,2},
                            {1,0.5,1,1,1,1,2,0.5,1,1,1,1,1,1,2,2,0.5,1}
                    };

    public double effectiveMultiplier(String attackType, String defenseType){
        int attackIndex = 0;
        int defenseIndex = 0;
        for(int i=0;i< typeChart.length;i++){
            if(attackType.compareTo(typeChart[i]) == 0){
                attackIndex = i;
            }
            if(defenseType.compareTo(typeChart[i]) == 0){
                defenseIndex = i;
            }
        }

        return effectivenessChart[attackIndex][defenseIndex];
    }


}
