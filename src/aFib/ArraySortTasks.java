package aFib;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by erik on 04.07.2015.
 */
public class ArraySortTasks {
        //    Сортировка массивов
//    71.
//    Заданы два
//    одномерных массива
//    с различным
//    количеством элементов
//    и натуральное
//    число k
//    .
//    Объединить их
//    в один
//    массив,
//    включив второй
//    массив между
//    k-
//
//    м и(k+1)
//
//    -
//    м элементами
//    первого,
//    не используя
//    дополнительный массив
//    . 72.
//    Даны две
//    последовательности a1
//    ≤a2≤  ...  ≤
//    аn и
//    b1≤b2≤  ...  ≤
//    bn.Образовать из
//    них новую
//    последовательность чисел
//    так,
//    чтобы она
//    тоже была
//
//    неубывающей(дополнительный массив не использовать)
//
//    . 73.
//    Сортировка выбором
//    .
//    Дана последовательность
//    чисел а1, а2, ...,
//    аn.Требуется переставить
//    элементы так, чтобы
//    они были
//    расположены по
//    убыванию.Для этого
//    в массиве, начиная
//    с первого, выбирается
//    наибольший элемент
//    и ставится
//    на первое
//    место,
//    а первый
//    –
//    на место
//    наибольшего.Затем,
//    начиная со
//    второго,
//    эта процедура
//    повторяется.Написать алгоритм
//    сортировки выбором
//    . 74.
//    Сортировка обменами
//    .
//    Дана последовательность
//    чисел а1, а2, ...,
//    аn.Требуется переставить
//    числа в
//    порядке возрастания
//    .
//    Для этого
//    сравниваются два
//    соседних числа
//    аi и
//    ai+1.
//    Если аi
//    >аi+1,
//    то делается
//    перестановка.Так продолжается
//    до тех
//    пор,
//    пока все
//    элементы не
//    станут расположены
//    в порядке
//    возрастания.Составить алгоритм
//    сортировки,
//    подсчитывая при
//    этом количество
//    перестановок. 75.
//    Сортировка вставками
//    .
//    Дана последовательность
//    чисел а1, а2, ...,
//    аn.Требуется переставить
//    числа в
//    порядке возрастания
//    .
//    Делается это
//    следующим образом
//    .
//    Пусть а1, а2, ...,аi–
//    упорядоченная последовательность, т
//    .е.a1≤a2≤ ... ≤
//    аi.Берется следующее
//    число ai
//    +1
//    и вставляется
//    в последовательность
//    так,
//    чтобы новая
//    последовательность была
//    также возрастающей
//    .
//    Процесс производится
//    до тех
//    пор,
//    пока всеэлементы
//    от i
//    +1
//    до n
//    не будут
//    перебраны.
//    76.
//    Сортировка Шелла
//    .
//    Дан массив
//    n действительных
//    чисел.Требуется упорядочить
//    его по
//    возрастанию.Делается это
//    следующим образом
//    :
//    сравниваются два
//    соседних элемента
//    ai и
//    аi+1.
//    Если ai
//    ≤ai+1,
//    то продвигаются
//    на один
//    элемент вперед
//    .
//    Если ai
//    >ai+1,
//    то производится
//    перестановка и
//    сдвигаются на
//    одинэлемент назад
//    .
//    Составить алгоритм
//    этой сортировки
//    .
        static Scanner num = new Scanner(System.in);
        static Random random = new Random();

        public static void main(String[] args) {
            int input = -1;
            while (input != 0) {
                System.out
                        .print("Enter task number 1-6\n\t\t\t or 0 if u wanna quit\n");
                input = num.nextInt();
                switch (input) {
                    case 1:
                        System.out.print("Task 1\n");
                        System.out
                                .print("Slivayanie dvuh masivov, vtoroi posle k elementov\n");
                        arrT1();
                        break;
                    case 2:
                        System.out.print("Task 2\n");
                        System.out.print("Slit' dva masiva i otsortirovat'\n");
                        arrT2();
                        break;
                    case 3:
                        System.out.print("Task 3\n");
                        System.out.print("Sortirovka viborom \n");
                        arrT3();
                        break;

                    case 4:
                        System.out.print("Task 4\n");
                        System.out.print("Sortirovka obmenami, puzir'kovaya\n");
                        arrT4();
                        break;
                    case 5:
                        System.out.print("Task 5\n");
                        System.out.print("Sortuvannya vstavkami\n");
                        arrT5();
                        break;

                    case 6:
                        System.out.print("Task 6\n");
                        System.out.print("Sortirovka Shella\n");
                        arrT6();
                        break;

                    case 7:

                        break;

                }
            }
        }

        public static void arrT1() {
            System.out.print("Enter arr1 size\n");
            int arrSizeT1 = num.nextInt();
            System.out.print("Enter arr2 size\n");
            int arrSizeT2 = num.nextInt();
            int[] ar1T1 = new int[arrSizeT1];
            for (int i = 0; i < ar1T1.length; i++) {
                ar1T1[i] = random.nextInt(9) + 1;
            }
            System.out.print("Arr 1\n");
            for (int i = 0; i < ar1T1.length; i++) {
                System.out.print(ar1T1[i] + "\t");
            }

            System.out.print("\n");

            int[] ar2T1 = new int[arrSizeT2];
            for (int i = 0; i < ar2T1.length; i++) {
                ar2T1[i] = random.nextInt(9) + 1;
            }
            System.out.print("Arr 2\n");
            for (int i = 0; i < ar2T1.length; i++) {
                System.out.print(ar2T1[i] + "\t");
            }
            System.out.print("\n");
            int[] ar3T1 = new int[ar1T1.length + ar2T1.length];
            int kT1 = 3;
            for (int i = 0; i < kT1; i++) {
                ar3T1[i] = ar1T1[i];
            }
            for (int i = kT1; i < kT1 + ar2T1.length; i++) {
                ar3T1[i] = ar2T1[i - kT1];
            }
            for (int i = kT1 + ar2T1.length; i < ar3T1.length; i++) {
                ar3T1[i] = ar1T1[i - ar2T1.length];
            }
            System.out.print("Arr 3\n");
            for (int i = 0; i < ar3T1.length; i++) {
                System.out.print(ar3T1[i] + "\t");
            }
            System.out.print("\n");
        }

        public static void arrT2() {
            System.out.print("Enter size 'n' for arr1 and arr2 \n");
            int nT2 = num.nextInt();
            int[] ar1T2 = new int[nT2];
            for (int i = 0; i < ar1T2.length; i++) {
                ar1T2[i] = random.nextInt(9) + 1;
            }
            System.out.print("Arr 1\n");
            for (int i = 0; i < ar1T2.length; i++) {
                System.out.print(ar1T2[i] + "\t");
            }
            System.out.print("\n");

            int[] ar2T2 = new int[nT2];
            for (int i = 0; i < ar2T2.length; i++) {
                ar2T2[i] = random.nextInt(9) + 1;
            }
            System.out.print("Arr 2\n");
            for (int i = 0; i < ar2T2.length; i++) {
                System.out.print(ar2T2[i] + "\t");
            }
            System.out.print("\n");

            for (int i = 0; i < ar1T2.length; i++) {
                for (int j = 0; j < ar1T2.length; j++) {
                    if (ar1T2[i] < ar1T2[j]) {
                        int tmpT2 = ar1T2[i];
                        ar1T2[i] = ar1T2[j];
                        ar1T2[j] = tmpT2;
                    }
                }
            }
            System.out.print("Arr 1 sorted\n");
            for (int i = 0; i < ar1T2.length; i++) {
                System.out.print(ar1T2[i] + "\t");
            }

            System.out.print("\n");

            for (int i = 0; i < ar2T2.length; i++) {
                for (int j = 0; j < ar2T2.length; j++) {
                    if (ar2T2[i] < ar2T2[j]) {
                        int tmpT2 = ar2T2[i];
                        ar2T2[i] = ar2T2[j];
                        ar2T2[j] = tmpT2;
                    }
                }
            }
            System.out.print("Arr 2 sorted\n");
            for (int i = 0; i < ar2T2.length; i++) {
                System.out.print(ar2T2[i] + "\t");
            }
            System.out.print("\n");

            int[] ar3T2 = new int[ar1T2.length + ar2T2.length];
            for (int i = 0; i < ar3T2.length; i++) {
                if (i < ar1T2.length) {
                    ar3T2[i] = ar1T2[i];
                } else {
                    ar3T2[i] = ar2T2[i - ar1T2.length];
                }
                for (int j = 0; j < ar3T2.length; j++) {
                    if (ar3T2[i] < ar3T2[j]) {
                        int tmpT2 = ar3T2[i];
                        ar3T2[i] = ar3T2[j];
                        ar3T2[j] = tmpT2;
                    }
                }
            }
            System.out.print("Arr 3 sorted\n");
            for (int i = 0; i < ar3T2.length; i++) {
                System.out.print(ar3T2[i] + "\t");
            }

            System.out.print("\n");
        }

        public static void arrT3() {
            System.out.print("Enter arr1 size\n");
            int arrSizeT3 = num.nextInt();

            int[] ar1T3 = new int[arrSizeT3];
            for (int i = 0; i < ar1T3.length; i++) {
                ar1T3[i] = random.nextInt(9) + 1;
            }
            System.out.print("Arr 1\n");
            for (int i = 0; i < ar1T3.length; i++) {
                System.out.print(ar1T3[i] + "\t");
            }
            System.out.print("\n");

            for (int i = 0; i < ar1T3.length; i++) {
                int max = ar1T3[i];
                int imax = i;
                for (int j = i + 1; j < ar1T3.length; j++) {
                    if (ar1T3[j] > max) {
                        max = ar1T3[j];
                        imax = j;
                    }
                }
                if (i != imax) {
                    int tmp = ar1T3[i];
                    ar1T3[i] = ar1T3[imax];
                    ar1T3[imax] = tmp;
                }
            }

            System.out.print("Arr 1 sorted\n");
            for (int i = 0; i < ar1T3.length; i++) {
                System.out.print(ar1T3[i] + "\t");
            }
            System.out.print("\n");
        }

        public static void arrT4() {
            System.out.print("Enter arr1 size 'n'\n");
            int arrSizeT4 = num.nextInt();

            int[] ar1T4 = new int[arrSizeT4];
            for (int i = 0; i < ar1T4.length; i++) {
                ar1T4[i] = random.nextInt(9) + 1;
            }
            System.out.print("Arr 1\n");
            for (int i = 0; i < ar1T4.length; i++) {
                System.out.print(ar1T4[i] + "\t");
            }
            System.out.print("\n");
            int count1 = 0;
            for (int i = 0; i < ar1T4.length; i++) {
                for (int j = 0; j < ar1T4.length; j++) {
                    if (ar1T4[i] < ar1T4[j]) {
                        int tmpT2 = ar1T4[i];
                        ar1T4[i] = ar1T4[j];
                        ar1T4[j] = tmpT2;
                        count1++;
                    }
                }
            }
            System.out.print("Arr 1 sorted\n");
            for (int i = 0; i < ar1T4.length; i++) {
                System.out.print(ar1T4[i] + "\t");
            }
            System.out.print("\n");
            System.out.print("count1\n" + count1);
            System.out.print("\n");
        }

        public static void arrT5() {
            System.out.print("Enter arr1 size 'n'\n");
            int arrSizeT5 = num.nextInt();
            int[] ar1T5 = new int[arrSizeT5];
            for (int i = 0; i < ar1T5.length; i++) {
                ar1T5[i] = random.nextInt(9) + 1;
            }
            System.out.print("Arr 1\n");
            for (int i = 0; i < ar1T5.length; i++) {
                System.out.print(ar1T5[i] + "\t");
            }
            for (int i = 1; i < ar1T5.length; i++) {
                int current = ar1T5[i];
                int previous = i - 1;
                while (previous >= 0 && ar1T5[previous] > current) {
                    ar1T5[previous + 1] = ar1T5[previous];
                    ar1T5[previous] = current;
                    previous--;
                }
            }
            System.out.print("\n");
            System.out.print("Arr 1 sorted\n");
            for (int i = 0; i < ar1T5.length; i++) {
                System.out.print(ar1T5[i] + "\t");
            }
            System.out.print("\n");
        }

        public static void arrT6() {
            System.out.print("Enter arr1 size\n");
            int arrSizeT6 = num.nextInt();

            int[] ar1T6 = new int[arrSizeT6];
            for (int i = 0; i < ar1T6.length; i++) {
                ar1T6[i] = random.nextInt(9) + 1;
            }
            System.out.print("Arr 1\n");
            for (int i = 0; i < ar1T6.length; i++) {
                System.out.print(ar1T6[i] + "\t");
            }
            System.out.print("\n");

            int d;
            d = arrSizeT6;
            d = d / 2;
            while (d > 0) {
                for (int i = 1; i < ar1T6.length - d; i++) {
                    int j = i;
                    while (j > 0 && ar1T6[j] > ar1T6[j + d]) {
                        int tmp = ar1T6[j];
                        ar1T6[j] = ar1T6[j + d];
                        ar1T6[j + d] = tmp;
                        j--;
                    }
                }
                d = d / 2;
            }
            System.out.println();
            for (int i = 1; i < ar1T6.length; i++) {
                System.out.print(ar1T6[i] + "\t");
            }
            System.out.print("\n");
        }
    }

