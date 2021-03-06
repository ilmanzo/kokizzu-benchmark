//////////////////////////////
// comb.scala
object Comb {
    def newGap(gap: Int): Int = {
        var ngap : Int = (gap.toDouble / 1.3).toInt;
        if(ngap == 9 || ngap == 10) return 11;
        if(ngap < 1) return 1;
        return ngap;
    }
    def combSort(a: Array[Double]) : Array[Double] = {
        var res : Array[Double] = a;
        val len = a.length;
        var gap = len;
        var temp : Double = 0;
        var swapped : Boolean = false;
        do {
            swapped = false;
            gap = newGap(gap);
            for(i <- 0 until len-gap if res(i) > res(i+gap)) {
                swapped = true;
                temp = res(i);
                res(i) = res(i+gap);
                res(i+gap) = temp;
            }
        } while(gap > 1 || swapped);
        return res
    }
    val N = 10000000;
    def main(args: Array[String]) {
        var arr : Array[Double] = new Array[Double](N)
        for(z <- 0 until N) arr(z) = N-z;   
        arr = combSort(arr); 
        for(z <- 1 until N if arr(z)<arr(z-1)) print("!");
    }
}
