package com.warren.utilities

fun isCPF(document: String): Boolean {
    if (document.isEmpty()) return false
    val numbers = document.filter { it.isDigit() }.map {
        it.toString().toInt()
    }
    if (numbers.size != 11) return false
    if (numbers.all { it == numbers[0] }) return false
    val dv1 = ((0..8).sumOf { (it + 1) * numbers[it] }).rem(11).let {
        if (it >= 10) 0 else it
    }
    val dv2 = ((0..8).sumOf { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
        if (it >= 10) 0 else it
    }
    return numbers[9] == dv1 && numbers[10] == dv2
}


fun isCnpj(et: String): Boolean{
    var str = et.replace("-", "").replace("/","").replace(".","")
    var calc: Int
    var num = 5
    var sum = 0
    for(x in 0..11) {
        calc = str[x].toString().toInt() * num
        sum += calc
        --num
        if(num == 1) num = 9
    }
    var rest = sum % 11
    var test = 11 - rest
    if(test < 2) test = 0
    if(test != str[12].toString().toInt()) return false
    num = 6
    sum = 0
    for(x in 0..12) {
        calc = str[x].toString().toInt() * num
        sum += calc
        --num
        if(num == 1) num = 9
    }
    rest = sum % 11
    test = 11 - rest
    if(test < 2) test = 0
    if(test != str[13].toString().toInt()) return false
    return true
}