var SPRITE_COLOR = white
var PARTICLE_COLOR = white
var PERCENT_ON = 0.7
var MIN_DETECTION_WIDTH = 6
var MIN_DETECTION_HEIGHT = 6
var MIN_DETECTION_PIXELS = 140
var MIN_BG_DIFFERENCE = 900
val MAX_DIFFERENCE_FOR_ALL_BG = 2000

var project = "ratime"

// debug
const val SAVE_COLORED = false
const val RESIZED = false
const val BLACK_AND_WHITE = false
const val SAVE_SIMILAR = true



const val SCREEN_WIDTH = 32
const val SCREEN_HEIGHT = 24
const val SCREEN_SIZE = SCREEN_WIDTH * SCREEN_HEIGHT
const val BYTE_SIZE = SCREEN_SIZE * 8
const val FRAME_SIZE = BYTE_SIZE + SCREEN_SIZE

val STATUS_BAR = Rect(0, 0, 32, 6)
val MAIN_SCREEN = Rect(0, 6, 32, 18)

val PIXEL_WIDTH = MAIN_SCREEN.pixelWidth()
val PIXEL_HEIGHT = MAIN_SCREEN.pixelHeight()
val PIXEL_SIZE = MAIN_SCREEN.pixelSize()

const val BORDER_SIZE = 4
const val MAX_DISTANCE = 3
const val MIN_WIDTH = 10
const val MAX_WIDTH = 80
const val MIN_HEIGHT = 6
const val MAX_HEIGHT = 90
const val MIN_FRAMES = 5
const val FRAME_FREQUENCY = 1
const val OUT_DIR = "D:/output/"

var defaultArea = Rect(0, 0, 256, 144)

val MAX_BG_DIFFERENCE = DefaultMap(300, mapOf(
  24350 to 900, 27654 to 900, 28366 to 900, 34454 to 900, 55614 to 900
  , 57410 to 900))

var particles = mapOf(
    2437 to Rect(40, 88, 64, 48)
  , 3012 to Rect(32, 136, 168, 8)
  , 14848 to Rect(48, 80, 64, 64)
  , 23687 to Rect(80, 136, 104, 8)
  , 24350 to Rect(88, 60, 128, 88)
  , 34234 to defaultArea
)

const val SHOW_DETECTION_AREA = false
//const val SHOW_DETECTION_AREA = true
const val SHOW_BG_DIFFERENCE = false
//const val SHOW_BG_DIFFERENCE = true
val mode = Mode.DECLASH
//val mode = Mode.SHOW_DIFFERENCE
//val mode = Mode.SCREENSHOTS
val ONLY_BACKGROUND = -1

fun process() {
  locations()

  // 1, 3012, 6915, 57206
  Screen.process(34702 - 1, 35000)

  when(mode) {
    Mode.COLOR_BACKGROUNDS -> {
      Screen.saveBackgrounds()
    } Mode.EXTRACT_BACKGROUNDS -> {
    } Mode.EXTRACT_SPRITES -> {
      ImageExtractor.saveImages()
    } Mode.DECLASH -> {
    } else -> {
    }
  }
}

fun locations() {
  Sprites.loadSeveral("player", 0.7, 1000
    , true)

  val planeArea = Rect(0, 0, 32, 18)
  Sprites.load("plane", 0.4, 1000
    , true) { frame: Int -> if(frame == 1) defaultArea else null }

  Sprites.load("cyan_island", 0.6, 100
    , false) { frame: Int -> if(frame == 3012)
      Rect(0, 128, 256, 16) else null }
  Sprites.load("white_island", 0.6, 100
    , true) { frame: Int -> if(frame == 23687)
      Rect(72, 128, 112, 16) else null }
  Sprites.load("red_island", 0.6, 100
    , true) { frame: Int -> when(frame) {
    24350 -> Rect(0, 128, 256, 16)
    45276 -> Rect(112, 112, 64, 32)
    else -> null
  }}
  Sprites.load("wall", 0.8, 10
    , true) {frame: Int -> if(frame == 27654)
    Rect(104, 112, 16, 32) else null}
  Sprites.load("stone", 0.8, 10
    , true) {frame: Int -> if(frame == 27654)
    Rect(28, 112, 60, 16) else null}
  Sprites.load("sand_bag", 0.8, 10
    , true) {frame: Int -> if(frame == 27654)
    Rect(104, 96, 16, 32) else null}

  Sprites.setLocations("arrow_block", listOf(
    752, 96, 112
    , 2041, 80, 104 // 104, 112
    , 2246, 184, 112 // 104, 112
    , 2246, 96, 112 // 104, 112
    , 2655, 200, 112
    , 3192, 176, 112
    , 5038, 120, 104
    , 5302, 88, 104, 5302, 152, 104, 5302, 184, 104
    , 5371, 88, 104, 5371, 120, 104, 5371, 216, 104
    , 5652, 40, 112, 5652, 128, 112
    , 13052, 144, 104
    , 14646, 8, 112
    , 14848, 128, 120
    , 17627, 96, 112, 17627, 176, 104
    , 20249, 120, 96
    , 21450, 24, 104, 21450, 88, 104, 21450, 216, 104
    , 25310, 96, 104
    , 27654, 216, 104
    , 27945, 24, 104, 27945, 56, 104, 27945, 88, 104, 27945, 184, 104
    , 27945, 216, 104
    , 28366, 176, 104
    , 52858, 176, 112, 52858, 224, 112
    , 53521, 88, 112, 53521, 136, 112, 53521, 184, 112
    , 57206, 56, 104, 57206, 128, 104
  ))

  Sprites.setLocations("hourglass_block", listOf(
    5302, 24, 112
    , 6309, 40, 112
    , 10065, 104, 112
    , 15467, 168, 88
    , 17732, 144, 112
    , 23474, 120, 112
    , 29968, 104, 112
    , 34454, 120, 112
    , 38391, 8, 56
    , 43257, 128, 96
    , 46957, 64, 104
    , 49553, 144, 112
    , 54125, 120, 112
  ))

  Sprites.setLocations("umbrella_block", listOf(
    1105, 120, 120
    , 3012, 216, 112
    , 44041, 80, 72))
  Sprites.setLocations("plug_block", listOf(
    3012, 224, 112))
  Sprites.setLocations("cheese_block", listOf(
    6915, 184, 112
    , 2437, 48, 64))
  Sprites.setLocations("coat_block", listOf(
    6915, 120, 104
    , 36376, 16, 112))
  Sprites.setLocations("fish_block", listOf(
    6541, 80, 96))
  Sprites.setLocations("head_dress_block", listOf(
    6915, 112, 120
    , 28698, 40, 112))
  Sprites.setLocations("wrench_block", listOf(
    13225, 136, 112))
  Sprites.setLocations("ball_block", listOf(
    14646, 168, 120))
  Sprites.setLocations("axe_block", listOf(
    14848, 128, 120))
  Sprites.setLocations("bush_block", listOf(
    17732, 168, 104))
  Sprites.setLocations("sphinx_block", listOf(
    18227, 88, 120))
  Sprites.setLocations("sand_block", listOf(
    25632, 224, 120))
  Sprites.setLocations("salt_block", listOf(
    44041, 80, 72))
}