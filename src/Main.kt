/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()    // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel
    private lateinit var helloButton: JButton

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        greetingLabel = JLabel("Hello, World!")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 50, 500, 100)
        greetingLabel.font = defaultFont
        add(greetingLabel)

        helloButton = JButton("Click Me!")
        helloButton.bounds = Rectangle(50,200,500,100)
        helloButton.addActionListener(this)     // Handle any clicks
        helloButton.foreground = Color(255, 255, 255)
        helloButton.background = Color(0x8BC1D9FF.toInt())
        helloButton.font = defaultFont
        add(helloButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            helloButton -> {
                greetingLabel.text = "You clicked the button!"
            }
        }
    }

}

