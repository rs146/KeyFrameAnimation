package guuilp.github.com.keyframeanimation

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_my.*

class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        var changed = false

        val constraintSet1 = ConstraintSet()
        constraintSet1.clone(this, R.layout.activity_my)
        val constraintSet2 = ConstraintSet()
        constraintSet2.clone(this, R.layout.activity_my_alt)

        animate.setOnClickListener { _ ->
            TransitionManager.beginDelayedTransition(findViewById(R.id.constraintLayout))
            val constraint = if (changed) constraintSet1 else constraintSet2
            constraint.applyTo(constraintLayout)
            changed = !changed
        }
    }

}
