import java.util.Arrays;

public class Boxers {

    public static void main(String[] args) {

        int[] englishBoxers = {73, 64, 81, 54, 82, 73, 62, 91, 83};
        int[] frenchBoxers = {51, 82, 58, 67, 85, 100, 78, 91, 130, 72};
        int[] weightCategories = {52, 57, 63, 71, 79, 91};
        int[] all = new int[englishBoxers.length + frenchBoxers.length];

        System.out.println("1. feladat  Mennyi az angol boxolók átlagos testsúlya?");
        System.out.println(averageWeightOfEnglishBoxers(englishBoxers));
        System.out.println();

        System.out.println(Arrays.toString(allBoxers(englishBoxers, frenchBoxers)));
        System.out.println();

        System.out.println("2. feladat  Hángy kg-s a legnehezebb boxoló?");
        System.out.println(heaviestBoxer(englishBoxers, frenchBoxers));
        System.out.println();

        System.out.println("3. feladat  Van két olyan boxoló, akik együtt is könnyebbek mint a legnehezebb " +
                "boxoló? KIk ők (hány kg-sak)?");
        twoBoxersLighterThanHeaviest(englishBoxers, frenchBoxers);
        System.out.println();

        System.out.println("4. feladat  Hányan boxolnak az egyes súlycsoportokban?");
        System.out.println(Arrays.toString(numOfBoxersPerWeightCat(englishBoxers, frenchBoxers, weightCategories)));
        System.out.println();

        System.out.println("5. feladat  Van-e olyan boxoló, aki mérkőzés nélkül is nyerni fog " +
                "(mert egyedül van a súlycsoportjában)?");
        System.out.println(isThereALoneWinner(englishBoxers, frenchBoxers, weightCategories));
        System.out.println();

        System.out.println("6. feladat  Van-e olyan súlycsoport, ahol garantált a francia aranyérem " +
                "(mert csak franciák indulnak)? Ha igen melyek ezek?");
        frenchWinOnly(weightCategories, frenchBoxers);
        System.out.println();

        System.out.println("7. feladat  Hány azonos súlyú angol boxoló van? Írd ki a súlyukat!");
        sameWeightEnglishBoxers(englishBoxers);
        System.out.println();

        System.out.println("8. feladat  Hány olyan francia boxoló van, aki pontosan azonos súlyú egy angol boxolóval? " +
                "Írd ki a súlyukat!");
        sameWeightEnglishAndFrenchBoxers(englishBoxers, frenchBoxers);
        System.out.println();

        System.out.println(Arrays.toString(boxersPerWeightCats(englishBoxers, 71, 79)));
        System.out.println();

        System.out.println("9. feladat  Írd ki, hogy súlycsoportonként milyen mérkőzések lesznek " +
                "(hogy milyen súlyú boxolók küzdenek egymással).");
        matchesPerWeightCats(englishBoxers, frenchBoxers, weightCategories);
        System.out.println();

    }

    public static double averageWeightOfEnglishBoxers(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static int[] allBoxers(int[] arr1, int[] arr2) {
        int[] all = new int[arr1.length + arr2.length];
        int idx = 0;
        for (int i = 0; i < arr1.length; i++) {
            all[idx++] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            all[idx++] = arr2[i];
        }
        return all;
    }

    public static int heaviestBoxer(int[] arr1, int[] arr2) {
        int max = 0;
        int[] arr = allBoxers(arr1, arr2);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void twoBoxersLighterThanHeaviest(int[] arr1, int[] arr2) {
        int[] all = allBoxers(arr1, arr2);
        for (int i = 0; i < all.length; i++) {
            for (int j = i + 1; j < all.length; j++) {
                if (all[i] + all[j] < heaviestBoxer(arr1, arr2)) {
                    System.out.println(i + " " + j + " : " + all[i] + " és " + all[j]);
                }
            }
        }
    }

    public static int[] numOfBoxersPerWeightCat(int[] arr1, int[] arr2, int[] weightsCat) {
        int[] all = allBoxers(arr1, arr2);
        int[] weightsPerBoxres = new int[weightsCat.length + 1];
        int countLights = 0;
        int count = 0;
        boolean countSup = true;
        int idx = 0;
        for (int i = 0; i < weightsCat.length; i++) {
            for (int j = 0; j < all.length; j++) {
                if (i < 1 && all[j] <= weightsCat[0]) {
                    count++;
                } else if (i > 0 && all[j] <= weightsCat[i] && all[j] > weightsCat[i - 1]) {
                    count++;
                }
                if (countSup && all[j] > weightsCat[weightsCat.length - 1]) {
                    countLights++;
                }
            }
            weightsPerBoxres[idx++] = count;
            weightsPerBoxres[weightsPerBoxres.length - 1] = countLights;
            countSup = false;
            count = 0;
        }
        return weightsPerBoxres;
    }

    public static boolean isThereALoneWinner(int[] arr1, int[] arr2, int[] arr3) {
        boolean bo = false;
        int[] weightC = numOfBoxersPerWeightCat(arr1, arr2, arr3);
        for (int i = 0; i < weightC.length; i++) {
            if (weightC[i] == 1) {
                bo = true;
            }
        }
        return bo;
    }

    public static void frenchWinOnly(int[] arr, int[] arr2) {
        int count = 0;
        int sum = 0;
        boolean b = false;
        int supCount = 0;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (i == 0 && arr2[j] <= arr[i]) {
                    count++;
                    idx = arr2[j];
                } else if (i > 0 && arr2[j] <= arr[i] && arr2[j] > arr[i - 1]) {
                    count++;
                    idx = arr2[j];
                }
                if (arr2[j] > arr[arr.length - 1]) {
                    supCount++;
                    sum = arr2[j];
                }
            }
            if (count == 1) {
                System.out.println("A " + arr[i] + " kategóriában a " + idx + " kg súlyú boxoló egyedül van.");
            }
            if (supCount == 1) {
                System.out.println("A supernehéz kategóriában " + sum + " győz egyedül");
            }
            count = 0;
        }

    }

    public static void sameWeightEnglishBoxers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i] + " és " + arr[j] + "súlya ua.");
                }
            }
        }
    }

    public static void sameWeightEnglishAndFrenchBoxers(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.println(arr1[i] + " és " + arr2[j] + "súlya ua.");
                }
            }
        }
    }

    public static int[] boxersPerWeightCats(int[] boxers, int lowerLimit, int upperLimit) {
        int idx = 0;
        for (int i = 0; i < boxers.length; i++) {
            if (boxers[i] > lowerLimit && boxers[i] <= upperLimit) {
                idx++;
            }
        }

        int[] cats = new int[idx];
        idx = 0;

        for (int i = 0; i < boxers.length; i++) {
            if (boxers[i] > lowerLimit && boxers[i] <= upperLimit) {
                cats[idx++] = boxers[i];
            }
        }
        return cats;
    }

    public static void matchesPerWeightCats(int[] english, int[] french, int[] weightCategories) {
        int[] boxers = allBoxers(english, french);
        Arrays.sort(boxers);

        int[] newWeightCats = new int[weightCategories.length+2];
        for (int i = 0; i < weightCategories.length; i++) {
            newWeightCats[0] = 0;
            newWeightCats[i+1] = weightCategories[i];
        }
        newWeightCats[newWeightCats.length-1] = boxers[boxers.length-1];

        for (int i = 0; i < newWeightCats.length-1; i++) {
            int[] boxersPerCats = boxersPerWeightCats(boxers, newWeightCats[i], newWeightCats[i+1]);
            System.out.println("A " + newWeightCats[i+1] + " kategóriában");
            for (int j = 0; j < boxersPerCats.length; j++) {
                if (boxersPerCats.length == 1) {
                    System.out.println(boxersPerCats[j] + " nyert, mert egyedül indul.");
                } else {
                    for (int k = j + 1; k < boxersPerCats.length; k++) {
                        System.out.println(boxersPerCats[j] + " és " + boxersPerCats[k] + " boxolnak");
                    }
                }
            }
            System.out.println();
        }
    }
}
