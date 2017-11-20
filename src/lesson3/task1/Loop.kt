@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import lesson1.task1.sqr
import javax.naming.NameNotFoundException
import java.lang.Math.*
/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int) :Int {
    var count = 0
    val dividend = 10
    var number = abs(n)
    if (number == 0) return count + 1
    while (number > 0) {
        if (number / dividend != 0 || number / dividend == 1 || number / dividend == 0) {
            count++
            number /= 10
        }
    }
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int = if (n > 2) fib(n - 1) + fib(n - 2) else 1


/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var i1: Int = Math.max(m,n)
    var i2: Int = Math.min(m,n)
    var result: Int = 0
    for (b in i1..i1 * i2) {
        if (b % i1 == 0 && b % i2 == 0) {
            result = b
            return result
        }
    }
    return result
}


/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var result: Int = 0
    for (i in 2..n) {
        if (n % i == 0) {
            result = i
            return result
        }
    }
    return result
}
/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var result: Int = 0
    for (i in 1..n - 1) {
         if (n % i == 0) {
            result = i

        }
    }
    return result
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int):Boolean {
    var a: Int = Math.min(m, n)
    for (i in 2..a) {
         if ( m % i == 0 && n % i == 0) {
            return false
        }
    }
    return true
}





/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var a: Int = min(m, n)
    var b: Int = max(m, n)
    for (i in a..b) {
        var c: Int = i
    for (j in 1 .. c){
        if ( j * j != c)
        return false
        }
    }
    return true
}
/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int   {
    var a : Int = 0
    var c:Int = n
    while ( c > 0) {
        var b:Int = c % 10
         a = b + a * 10
         c /= 10
    }
     return a
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    var a:Int = 0
    var c:Int = n
    while ( c > 0) {
        var b:Int = c % 10
            a = b + a * 10
            c /= 10
    }
    if (a == n) return true
    else return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean  {
   var b:Int = n
   var a:Int = b % 10
   var count:Int = 0
   while (b > 0){
        if (a != b % 10) {
        count++
   }
        b /= 10
        if (count >= 1) return true
   }
    return false
 }




/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
    fun squareSequenceDigit(n: Int): Int  {
    var a = mutableListOf<Int>(0) // создаю список из послеовательности квадратов
    var i = 0
    while (a.size-1 < n) {
        i++
        val digits = mutableListOf<Int>() // список для квадратов
        var sqrI = sqr(i.toDouble()).toInt()
        while (sqrI > 0) {
            digits.add(sqrI % 10)// раскладываю квадрат на элементы
            sqrI /= 10
        }
        digits.reverse()
        a.addAll(digits)
    }
    return a[n].toInt()
}


/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var a = mutableListOf<Long>(0, 1, 1) //  создаю список из последовательности чисел Фибоначчи
    var c = mutableListOf<Long>(0) // список,разбивающий числа > 9  списка а на отдельные элементы
    var i:Long = 2
    var v:Long = n.toLong()
        if (n == 1 || n == 2) return 1
        while (a.size - 1 < v) {
            i++
            val digits = mutableListOf<Long>()
            var b:Long = abs(a[(i - 1).toInt()] + a[(i - 2).toInt()]).toLong()
                    while (b > 0) {
                digits.add(b)
                    b -= b
            }
            a.addAll(digits)
        }
            for ( element in a) {
                val digits2 = mutableListOf<Long>()
                var element1:Long = element
                        while ( element1 > 0 ) {
                            digits2.add(element1 % 10)
                            element1 /= 10
                        }
                        digits2.reverse()
                        c.addAll(digits2)
            }
            return c[v.toInt()].toInt()
        }

