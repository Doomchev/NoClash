
// screen areas

val MAIN_SCREEN = Rect(0, 0, 32, 20)
val STATUS_BAR = Rect(0, 20, 32, 4)
val PIXEL_WIDTH = MAIN_SCREEN.pixelWidth()
val PIXEL_HEIGHT = MAIN_SCREEN.pixelHeight()
val PIXEL_SIZE = MAIN_SCREEN.pixelSize()

// main settings

var project = "sceptre"
const val OUT_DIR = "D:/output/"
const val XOR = true
const val RESIZED = false
const val BLACK_AND_WHITE = false
const val ONLY_ABSENT = false
//const val ONLY_ABSENT = true
const val TWO_FRAMES = true
//const val TWO_FRAMES = false

// mode

//val mode = Mode.SCREENSHOTS
//val mode = Mode.EXTRACT_BACKGROUNDS
val mode = Mode.DECLASH
//val mode = Mode.SHOW_DIFFERENCE

// backgrounds

const val MIN_BG_CHANGED = 0.55
const val SAVE_SIMILAR = true
const val SHOW_BG_DIFFERENCE = false
//const val SHOW_BG_DIFFERENCE = true
const val MIN_FRAMES = 4
const val PERCENT_ON = 0.7
const val MAX_BG_DIFFERENCE = 1800

// declash

const val BORDER_SIZE = 2
const val MAX_DISTANCE = 2
const val MIN_WIDTH = 10
const val MAX_WIDTH = 128
const val MIN_HEIGHT = 6
const val MAX_HEIGHT = 128
const val MIN_PIXELS = 36
const val SHOW_DETECTION_AREA = false
//const val SHOW_DETECTION_AREA = true
const val ANY_IS_CHANGED = false
//const val ANY_IS_CHANGED = true

//const val ONLY_BACKGROUND = "pool"
const val ONLY_BACKGROUND = ""

fun process() {
  sprites()
  //throne
  Screen.process(0, 5000)
  //Screen.process(5597 - 1, 10000)
  //Screen.process()
}

fun sprites() {
  Sprites.loadSeveral(
    "player", 0.6, 0.5, true, white
  , defaultArea, emptyMap())

  Sprites.loadSeveral("yellow", 0.3, 0.1
    , false, yellow, defaultArea, mapOf("pool" to null))

  Sprites.loadSeveral("white", 0.3, 0.1
    , false, white, defaultArea, mapOf("pool" to null))

  Sprites.loadSeveral("fish", 0.1, 0.5
    , true, white, null, mapOf("pool" to defaultArea))
}
