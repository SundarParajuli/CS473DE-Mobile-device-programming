package com.sundar.jetpackquiz.ui.onboarding

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sundar.jetpackquiz.R

class OnboardingViewPagerAdapter(
    fragmentActivity: Fragment,
    private val context: Context
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingPageFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_1),
                context.resources.getString(R.string.description_onboarding_1),
                R.raw.welcome
            )
            1 -> OnboardingPageFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_2),
                context.resources.getString(R.string.description_onboarding_2),
                R.raw.academic,
            )
            else -> OnboardingPageFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_3),
                context.resources.getString(R.string.description_onboarding_3),
                R.raw.learn,
            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}