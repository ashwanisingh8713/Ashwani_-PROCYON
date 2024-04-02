import androidx.compose.ui.window.ComposeUIViewController
import com.procyon.assesement.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
