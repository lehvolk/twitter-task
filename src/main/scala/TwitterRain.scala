/**
 * twitter rain task
 *
 * @author Alexey Volkov
 * @since 01.09.14
 */
object TwitterRain extends App {

	println("volume is " + volume(Array(1, 2, 3, 4, 5, 6))) //0
	println("volume is " + volume(Array(1, 2, 3, 4, 5, 6).reverse)) //0
	println("volume is " + volume(Array(1, 2, 3, 4, 5, 6).reverse ++ Array(1, 2, 3, 4, 5, 6))) //30
	println("volume is " + volume(Array(2, 5, 1, 2, 3, 4, 7, 7, 6))) //10
	println("volume is " + volume(Array(2, 5, 1, 2, 3, 4, 7, 7, 6).reverse)) //10
	println("volume is " + volume(Array(2, 5, 1, 2, 3, 4, 7, 5, 6))) //11
	println("volume is " + volume(Array(2, 5, 1, 2, 3, 4, 7, 5, 6).reverse)) //11

	def volume(land: Array[Int]): Int = {
		var sum: Int = 0
		val size: Int = land.length - 1

		var leftMax: Int = land(0)
		var rightMax: Int = land(size)

		var outerWater: Int = 0

		for (ind <- 0 to size) {
			if (land(ind) > leftMax) {
				outerWater += ind * (land(ind) - leftMax)
				leftMax = land(ind)
			}
			val right = size - ind
			if (land(right) > rightMax) {
				outerWater += ind * (land(right) - rightMax)
				rightMax = land(right)
			}
			sum += land(ind)
		}
		return leftMax * land.length - sum - outerWater
	}

}
