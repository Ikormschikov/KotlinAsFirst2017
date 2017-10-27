@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import  java.lang.Math.*

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    var years1 = "$age года"
    var years2 = "$age лет"
    var years3 = "$age год"
    return when {
        (age % 10 == 1) && (age % 100 / 10 != 1) -> years3
        (age % 10 in  2.. 4) && (age % 100 / 10 != 1) -> years1
        else -> years2
}
}


/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double = TODO()



/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    return when {
        (kingX == rookX1) || (kingY == rookY1) && (kingX == rookX2) || (kingY == rookY2) -> 3
        (kingX == rookX1) || (kingY == rookY1) -> 1
        (kingX == rookX2) || (kingY == rookY2) -> 2
        else -> 0
    }
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    return when {
        (kingX == rookX) || (kingY == rookY) && Math.abs(bishopX -  kingX)  ==  Math.abs(bishopY - kingY) -> 3
        (kingX == rookX) || (kingY == rookY) -> 1
        Math.abs(bishopX -  kingX)  ==  Math.abs(bishopY - kingY) -> 2
        else -> 0
    }
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
  val list = listOf(a,b,c).sorted() // создаем список чисел по возрастанию
    if (a + b <= c || a + c <= b || b + c <= a) {
        return - 1
    }
    for (i in list) {
        val angle = (sqr(list[0]) + sqr(list[1]) - sqr(list[2])) / (2.0 * list[0] * list[1]) // находим угол по теореме косинусов
        if (angle in - 1.0 .. - 0.01) { // проверяем по таблице Брадиса
            return 2
        }
        if (angle in 0.01 .. 0.99) {
            return 0
        }
        if (angle == 0.0) {
            return 1
        }
    }
    return 4
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    var e:Int = Math.max(a,b)
    var f:Int = Math.max(c,d)
    var g:Int = Math.min(a,b)
    var h:Int = Math.min(c,d)
    return when {
        b < c || d < a -> -1
        h > e || g > f -> 0
        h > g && h < e && e < f -> e - h
        g > h && g < f && f < e -> f - g
        f < e && f > g && h > g -> f - h
        e < f && e > h && g > h -> e - g
        g == h && e < f -> e - g
        g == h && f < e -> f - h
        g < h && e == f -> h - g
        h < g && e == f -> g - h
        else -> 0
    }
}


