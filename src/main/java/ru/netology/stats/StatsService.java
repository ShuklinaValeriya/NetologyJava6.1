package ru.netology.stats;

public class StatsService {

    // Считаем сумму всех продаж;
    public int calculateSum(int[] sales) {
        int sum = 0;
        for (int sale : sales) {
            sum += sale;
        }
        return sum;
    }

    //Считаем среднюю сумму продаж в месяц;
    public int calculateAvg(int[] sales) {
        return calculateSum(sales) / sales.length;
    }

    //Считаем номер последнего месяца,в котором был пик продаж;
    public int maxSales(long[] sales) {
        int maxMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return (maxMonth + 1);
    }

    //Считаем номер последнего месяца,в котором был минимум продаж;
    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return (minMonth + 1);
    }

    //Считаем кол-во месяцев, в которых продажи были ниже среднего;

    public int minAvgSales(int[] sales) {
        int minAvgMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        int counter = 0;
        for (int sale : sales) {
            // sales[minMonth] - продажи в месяце minAvgMonth
            // sale - продажи в рассматриваемом месяце
            if (sale < calculateAvg(sales)) {
                minAvgMonth = month; //сравниваю продажи каждого месяца со средними продажами
                counter++;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return (counter);
    }

//Считаем кол-во месяцев, в которых продажи были выше среднего;

    public int maxAvgSales(int[] sales) {
        int maxAvgMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        int counter = 0; // счетчик удовлетворяющих условию месяцев
        for (int sale : sales) {
            if (sale > calculateAvg(sales)) {
                maxAvgMonth = month; //сравниваю продажи каждого месяца со средними продажами
                counter++;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return (counter);
    }

}
