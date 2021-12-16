package com.axell.marvelcharacters.core.functional

/**
 * @see [https://developer.marvel.com/documentation/images]
 */
enum class ImageVariants(val variant:String) {
    PORTRAIT_SMALL("portrait_small"), // 50x75px
    PORTRAIT_MEDIUM("portrait_medium"), // 100x150px
    PORTRAIT_XLARGE("portrait_xlarge"), // 150x225px
    PORTRAIT_FANTASTIC("portrait_fantastic"),// 168x252px
    PORTRAIT_UNCANNY("portrait_uncanny"),// 300x450px
    PORTRAIT_INCREDIBLE("portrait_incredible"),// 216x324px

    STANDARD_SMALL("standard_small"), // 65x45 px
    STANDARD_MEDIUM("standard_medium"), // 100x100px
    STANDARD_XLARGE("standard_xlarge"), // 200x200px
    STANDARD_FANTASTIC("standard_fantastic"),// 250x250px
    STANDARD_AMAZING("standard_amazing"),// 180x180px

    LANDSCAPE_SMALL("landscape_small"), // 120x90px
    LANDSCAPE_MEDIUM("landscape_medium"), // 175x130px
    LANDSCAPE_LARGE("landscape_large"), // 190x140px
    LANDSCAPE_XLARGE("landscape_xlarge"), // 270x200px
    LANDSCAPE_UNCANNY("landscape_amazing"),// 250x156px
    LANDSCAPE_INCREDIBLE("landscape_incredible"),// 464x261px
    DETAIL("detail"),// Full image constraint to 500px wide
}