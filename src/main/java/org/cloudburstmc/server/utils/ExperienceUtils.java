package org.cloudburstmc.server.utils;

public class ExperienceUtils {

    /**
     * Calculates and returns the amount of XP needed to get from level 0 to level $level
     */
    public static int getXpToReachLevel(int level) {
        if(level <= 16){
            return (level * level) + level * 6;
        }
        else if(level <= 31){
            return (int) ((level * level) * 2.5 - 40.5 * level + 360);
        }

        return (int) ((level * level) * 4.5 - 162.5 * level + 2220);
    }

    /**
     * Returns the amount of XP needed to reach $level + 1.
     */
    public static int getXpToCompleteLevel(int level) {
        if(level <= 15){
            return 2 * level + 7;
        }
        else if(level <= 30){
            return 5 * level - 38;
        }
        else{
            return 9 * level - 158;
        }
    }

    /**
     * Calculates and returns the number of XP levels the specified amount of XP points are worth.
     * This returns a floating-point number, the decimal part being the progress through the resulting level.
     */
    public static float getLevelFromXp(int xp) {
        if(xp < 0){
            return 0;
        }

        double a,b,c;
        if(xp <= ExperienceUtils.getXpToReachLevel(16)){
            a = 1;
            b = 6;
            c = -xp;
        }
        else if(xp <= ExperienceUtils.getXpToReachLevel(31)){
            a = 2.5;
            b = -40.5;
            c = 360 - xp;
        }
        else {
            a = 4.5;
            b = -162.5;
            c = 2220 - xp;
        }

        double disc = (b * b) - 4 * a * c;
        if(disc > 0){ //2 real roots
            double sqrtDisc = Math.sqrt(disc);

            return (float) Math.max((-b + sqrtDisc) / (2 * a), (-b - sqrtDisc) / (2 * a));
        }else if(disc == 0){ //1 real root
            return (float) (-b / (2 * a));
        }
        else{ //No real roots
            return 0;
        }
    }
}
