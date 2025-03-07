/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application. The Java Swing library is used,
 * plus the FlatLAF look-and-feel for a reasonably modern look.
 */
import com.formdev.flatlaf.FlatDarkLaf
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.*

/** Launch the application */
fun main() {
    FlatDarkLaf.setup() // Flat, dark look-and-feel
    MainWindow() // Create and show the UI
}

/**
 * Main UI window (view) Defines the UI and responds to events The app model should be passwd as an
 * argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var textbox: JTextField
    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton

    /** Configure the UI and display it */
    init {
        configureWindow() // Configure the window
        addControls() // Build the UI

        setLocationRelativeTo(null) // Centre the window
        isVisible = true // Make it visible
    }

    /** Configure the main window */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 400)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /** Populate the UI with UI controls */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        greetingLabel = JLabel("Click a button...")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 25, 500, 100)
        greetingLabel.font = defaultFont
        greetingLabel.foreground = Color.WHITE
        add(greetingLabel)

        textbox = JTextField()
        textbox.bounds = Rectangle(50, 125, 500, 100)
        textbox.font = defaultFont
        textbox.addActionListener(this)
        textbox.addKeyListener(this)
        add(textbox)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(50, 250, 230, 100)
        helloButton.addActionListener(this) // Handle any clicks
        helloButton.font = defaultFont
        add(helloButton)

        goodbyeButton = JButton("Goodbye!")
        goodbyeButton.bounds = Rectangle(330, 250, 230, 100)
        goodbyeButton.addActionListener(this) // Handle any clicks
        goodbyeButton.font = defaultFont
        add(goodbyeButton)
    }

    /** Handle any UI events (e.g. button clicks) */
    override fun actionPerformed(e: ActionEvent?) {
        var adjustedText = textbox.text
        if (adjustedText == "") {
            adjustedText = "stranger"
        }
        when (e?.source) {
            textbox -> {
                println("Textbox updated ${textbox.text}")
            }
            helloButton -> {
                println("Hello pressed")
                greetingLabel.text = "Hello there, $adjustedText!"
                greetingLabel.foreground = Color.GREEN
            }
            goodbyeButton -> {
                println("Goodbye pressed")
                greetingLabel.text = "Goodbye, $adjustedText!"
                greetingLabel.foreground = Color.RED
            }
        }
    }

    override fun keyTyped(e: KeyEvent?) {
        println("Typed ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Pressed ${e?.keyCode}")
        if (e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z) {
            println("letter")
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        println("Released ${e?.keyCode}")
    }
}
