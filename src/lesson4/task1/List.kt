 @file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant
import java.lang.Math.*
import java.math.BigInteger
 /**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var a:Double = 0.0
        if (v.isEmpty()) return 0.0
    for (element in v) {
            a += element * element
    }
    return sqrt(a)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    var a: Double = 0.0
        val b: Double = list.size.toDouble()
    if (list.isEmpty()) return 0.0
        for (element in list) {
             a += element
    }
    return a / b
}


/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val a:Double = list.sum() / list.size
        if (list.isEmpty()) return list
            for (i in 0 until list.size ){
        val element = list[i]
            list[i] = element - a
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double = TODO()

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    if (p.isEmpty()) return 0.0
    var result = 0.0
    var b = 0.0
    var a = p.first()
    var b1 = 0.0
    if (p.size < 2) return a
    for (i in 1 until p.size) {
        b = p[i] * pow(x, i.toDouble())
        b1 = b1 + b
    }
    result = a + b1
    return result
}
/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var a = 0.0
    if (list.isEmpty()) return list
    for (i in 1 until list.size) {
        a = list[i] + list[i - 1]
        list[i] = a
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var dividend = n
    var divider = 2
    var multipliers =  mutableListOf<Int>()
    while (dividend > 1) {
        if (dividend % divider == 0) {
            multipliers.add (0 , divider)
            dividend /= divider
        }
       else divider++
    }
    multipliers = multipliers.sorted().toMutableList()
    return multipliers
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String {
    var dividend = n
    var divider = 2
    var multipliers =  mutableListOf<Int>()
    while (dividend > 1) {
        if (dividend % divider == 0) {
            multipliers.add (0 , divider)
            dividend /= divider
        }
        else divider++
    }
    multipliers = multipliers.sorted().toMutableList()
    return multipliers.joinToString ( separator = "*")
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    var number = BigInteger("$n")
    var convertNumber = number.toString(base)
    return convertNumber
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = 0
    val mutable = digits.toMutableList<Int>()
    var i = 0
    while (mutable.size > 0) {
            var last = mutable.last()
            var calculate = last * pow(base.toDouble(), i.toDouble()).toInt()
            result = result + calculate
            mutable.remove(mutable.last())
            i++
        }
        return result
    }

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    var number = BigInteger("$str", base)
    var convertNumber = number.toString(10)
    return convertNumber.toInt()
}

/**
 * Сложная
 *
 * Перевести натуальное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val figure = arrayListOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    val dozensOf = arrayListOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val hundreds = arrayListOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val thousandsOf = arrayListOf("", "M", "MM", "MMM")
    var list = mutableListOf<Any>()
    var number = n
    var count = 0
    val last = number % 10
    val last2 = (number % 100) / 10
    var second = (number % 1000) / 100
    val first = (number / 1000)
    while (number > 0) {
        number /= 10
        count++
    }
    number = n
    while (number > 0) {
            if (count == 1) {
                list.add(0, figure[number % 10])
                number -= number
            }
            if (count == 2) {
                list.add(0, figure[number % 10])
                list.add(0, dozensOf[(number % 100) / 10])
                number -= number
            }
            if (count == 3) {
                list.add(0, figure[number % 10])
                list.add(0, dozensOf[(number % 100) / 10])
                list.add(0, hundreds[(number % 1000) / 100])
                number -= number
            }
            if (count == 4) {
                list.add(0, figure[number % 10])
                list.add(0, dozensOf[(number % 100) / 10])
                list.add(0, hundreds[(number % 1000) / 100])
                list.add(0, thousandsOf[number / 1000])
                number -= number
            }
        }
        return list.joinToString(separator = "")
    }


 /**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
     val numeral = arrayListOf("","один","два","три","четыре","пять","шесть","семь","восемь","девять")
     val dozensOf = arrayListOf("","десять","двадцать","тридцать","сорок","пятьдесят","шестьдесят","семьдесят","восемьдесят","девяносто")
     val hundreds = arrayListOf("","сто","двести","триста","четыреста","пятьсот","шестьсот","семьсот","восемьсот","девятьсот")
     val thousandsOf = arrayListOf("","одна тысяча","две тысячи","три тысячи","четыре тысячи","пять тысяч","шесть тысяч",
     "семь тысяч","восемь тысяч","девять тысяч")
     val exception = arrayListOf("","одиннадцать","двенадцать","тринадцать","четырнадцать","пятнадцать","шестнадцать","семнадцать",
     "восемнадцать","девятнадцать")
     val exception2 = arrayListOf("","одиннадцать тысяч","двенадцать тысяч","тринадцать тысяч","четырнадцать тысяч","пятнадцать тысяч",
     "шестнадцать тысяч","семнадцать тысяч","восемнадцать тысяч","девятнадцать тысяч")
     var number = n
     var count = 0
     var list = mutableListOf<Any>()
     while (number > 0) {
         number /= 10
         count++
     }
     number = n
     while (number > 0) {
         if (count == 1) {
             list.add(numeral[number % 10])
             number -= number
         }
         if (count == 2) {
             if (number in 11 .. 19) {
                 list.add(exception[number % 10])
             }
             list.add(numeral[number % 10])
             list.add(dozensOf[(number % 100) / 10])
             number -= number
         }
         if (count == 3) {
             if (number % 100 in 11 .. 19) {
                 list.add(exception[number % 10])
             } else {
                 list.add(numeral[number % 10])
                 list.add(dozensOf[(number % 100) / 10])
             }
             list.add(hundreds[(number % 1000) / 100])
             number -= number
         }
         if (count == 4) {
             if (number % 100 in 11 .. 19) {
                 list.add(exception[number % 10])
             } else {
                 list.add(numeral[number % 10])
                 list.add(dozensOf[(number % 100) / 10])
             }
             list.add(hundreds[(number % 1000) / 100])
             list.add(thousandsOf[(number % 10000) / 1000])
             number -= number
         }
         if (count == 5) {
             if (number % 100 in 11 .. 19) {
                 list.add(exception[number % 10])
             } else {
                 list.add(numeral[number % 10])
                 list.add(dozensOf[(number % 100) / 10])
             }
             list.add(hundreds[(number % 1000) / 100])
             if (number / 1000 in 11 .. 19) {
                 list.add(exception2[(number / 1000) % 10])
             } else {
                 list.add(thousandsOf[(number % 10000) / 1000])
                 list.add(dozensOf[(number % 100000) / 10000])
             }
             number -= number
         }
         if (count == 6) {
             if (number % 100 in 11 .. 19) {
                 list.add(exception[number % 10])
             } else {
                 list.add(numeral[number % 10])
                 list.add(dozensOf[(number % 100) / 10])
             }
             list.add(hundreds[(number % 1000) / 100])
             if ((number % 100000) / 1000 in 11 .. 19) {
                 list.add(exception2[(number / 1000) % 10])
             } else {
                 list.add(thousandsOf[(number % 10000) / 1000])
                 list.add(dozensOf[(number % 100000) / 10000])
             }
             list.add(hundreds[(number % 1000000) / 100000])
             number -= number
         }
     }
     list.reverse()
     list.remove("")
     return list.joinToString(separator = " ")
 }