package com.cjp.confapp.model

import androidx.lifecycle.ViewModel

class ConfViewModel : ViewModel() {

    companion object {
        fun newInstance() = ConfViewModel()
    }

    var used = false

    val allTalks = listOf(
        Talk("arkit", "Using ARKit with SpriteKit", "ARKit is the hot new framework announced at WWDC 2017. This workshop will get your feet wet so that you can create the augmented reality application of your dreams. ", "b23", "2019-12-10", 0,  "16:00", "18:00", "talk", "JanieClayton"),
        Talk("spoons", "Optional Social", "Come to Yr Hen Orsaf (local Wetherspoons) when you arrive in Aber, and meet some other delegates. If you are coming to Aber by train, it is easy to find - it's part of the railway station.", "spoons", "2019-12-10", 1,  "18:00", "23:59", "dinner", ""),
        Talk("registration", "Registration", "Collect your badge and registration goodies,.", "foyer", "2019-12-11", 0,  "09:00", "09:30", "registration", ""),
        Talk("welcome", "Welcome / Introduction", "A welcome to iOSDevUK 2017 and some information about the conference and the conference meal later today.", "physmain", "2019-12-11", 1,  "09:30", "09:40", "talk", "NeilTaylor"),
        Talk("coreml", "I'll tell you what you can do with Core ML", "The introduction of CoreML in iOS 11 got the community very excited about machine learning, and how it will 'change the world'.", "physmain", "2019-12-11", 2,  "09:40", "10:20", "talk", "SamDavies"),
        Talk("indieos", "Indie iOS Development: Things I've learnt after 5 million downloads", "Sarp's talk will be about building App Store hits as an indie developer, the strategies he and his partner used to market our products as well as the technologies and design tools we’ve chosen.", "physmain", "2019-12-11", 3,  "10:20", "11:00", "talk", "SarpErdag"),
        Talk("coffee1", "Coffee Break", "Coffee and cakes available in the Physics Foyer. ", "foyer", "2019-12-11", 4,  "11:00", "11:30", "coffee", ""),
        Talk("iotwithswift", "Programming the Internet of Things with Swift", "Now that Swift is open source, can it be made to run on battery-powered Internet of Things devices running at 48-MHz with as little as 20KB of RAM? Let's find out! And along the way we'll also try to answer the question: Why?", "physmain", "2019-12-11", 5,  "11:30", "12:10", "talk", "StevenGray"),
        Talk("serverswift", "What App Developers Should Know about Server-Side Swift", "What App Developers Should Know about Server-Side Swift", "physmain", "2019-12-11", 6,  "12:10", "12:50", "talk", "ClausHofele"),
        Talk("lunch1", "Lunch", "Lunch is available in the Physics Foyer, where you registered. ", "foyer", "2019-12-11", 7,  "12:50", "14:00", "lunch", ""),
        Talk("uiautomation", "UI Automation in Mobile Apps", "How Trainline uses Xode UI Automation techniques - with code examples and how to approach it.", "a6", "2019-12-11", 8,  "14:00", "14:40", "talk", "AndreyKozlov"),
        Talk("animation", "Taming Animation", "Animations set iOS apart from Android, they are the signature garnish on top of every app recognized by Apple Design Awards.", "a6", "2019-12-11", 9,  "14:40", "15:20", "talk", "SashZats"),
        Talk("codesigning", "At This Point Size in Time", "Achieving better accessibility, legibility and visual consistency in your app through Dynamic Type support.", "a6", "2019-12-11", 10,  "15:20", "16:00", "talk", "RossButler"),
        Talk("coffee2", "Coffee Break", "Coffee and biscuits available in the Physics Foyer. ", "foyer", "2019-12-11", 11,  "16:00", "16:30", "coffee", ""),
        Talk("fileextensions", "File provider extensions in iOS 11", "iOS 11 introduces a new extension point, File Provider, for cloud storage services to hook into the Files app and other apps that support file browsing. Let's learn how to make one!", "physmain", "2019-12-11", 12,  "16:30", "17:10", "talk", "AmyWorrall"),
        Talk("continuousdelivery", "Continuous Delivery", "A detailed talk on how you can make continuous delivery to the App Store. Using Jenkins as the CI and Jira for task management bundled in an automated pipeline to help speed up your App Store delivery process.", "physmain", "2019-12-11", 13,  "17:10", "17:50", "talk", "AdamRush"),
        Talk("dinner", "Conference Dinner", "The meal is ordered. The location is set. The drinks are paid for. Come along and relax and chat about iOS, the Aberystwyth sunset, or anything else you fancy.", "medrus", "2019-12-11", 14,  "19:00", "22:00", "dinner", ""),
        Talk("fasttech1", "Hi tech fast talks", "Talks on exciting tech of the moment", "physmain", "2019-12-12", 1,  "09:30", "10:40", "talk", ""),
        Talk("coffee3", "Coffee Break", "Coffee and cakes available in the Physics Foyer. ", "foyer", "2019-12-12", 2,  "10:40", "11:20", "coffee", ""),
        Talk("swiftmemmanagement", "Brokering Resources: iOS, the user...& YOU!", "As iOS developers, it’s our job to leverage Apple's ecosystem to delight our users. In practice, this means making the “right” decisions and moving quickly to deliver each new valuable feature.", "physmain", "2019-12-12", 3,  "11:20", "12:00", "talk", "RebeccaEakins"),
        Talk("lensesprisms", "Lenses and Prisms in Swift", "The concept of functional lens has become pretty popular in functional programming circles, and there are already good contributions for applying lenses to other, traditionally imperative/OO contexts, like Javascript. I'd like to offer a more in depth view on why lenses can be useful in Swift, and also talk about a similar/different thing called Prism: it's likely that everyone that's interested in lenses has heard about prisms but it seems like, while the basic intuition behind a lens can be grasped, the one behind a prism is kind of obscure.", "physmain", "2019-12-12", 4,  "12:00", "12:40", "talk", "ElviroRocca"),
        Talk("lunch2", "Lunch", "Lunch is available in the Physics Foyer, where you registered. ", "foyer", "2019-12-12", 5,  "12:40", "14:00", "lunch", ""),
        Talk("multilingual", "Multilingual Swift: How to play nicely with other languages", "As Swift gets more widely used, it is becoming necessary to link it to frameworks written in other languages. Martin explains the features of the language that enable links to a wide range of other languages.", "physmain", "2019-12-12", 6,  "14:00", "14:40", "talk", "MartinPilkington"),
        Talk("guerillas", "Working with Guerillas - coding UX in every app", "As Software Engineers, it is our job to surprise and delight our users; providing engaging user experiences that does not detract from the key functionality of our products.", "physmain", "2019-12-12", 7,  "14:40", "15:20", "talk", "SteveWestgarth"),
        Talk("coffee4", "Coffee Break", "Coffee and biscuits available in the Physics Foyer. ", "foyer", "2019-12-12", 8,  "15:20", "15:50", "coffee", ""),
        Talk("scriptableios", "Making Scriptable iOS Apps", "I will talk about how you can provide a Javascript interface to your app and how it can help during development, as well as providing advanced users with increased powers.", "physmain", "2019-12-12", 9,  "15:50", "16:30", "talk", "DanielTull"),
        Talk("accessibility", "What minority are you in? - Accessibility in mobile apps", "This talk will look at the important issues to take into account when making your app accessible.", "physmain", "2019-12-12", 10,  "16:30", "17:10", "talk", "AgnieszkaCzyzak"),
        Talk("healthcare", "From Indie to CTO", "From Indie to CTO. Overcoming personal fears, such as imposter syndrome, to grow professionally, and the role that attending conferences can play in that journey", "physmain", "2019-12-12", 11,  "17:10", "17:50", "talk", "AlanMorris"),
        Talk("fasttech2", "Lightning talks", "Short talks on developer subjects.", "physmain", "2019-12-13", 1,  "09:30", "10:10", "talk", ""),
        Talk("codable", "Decoding Codable", "Apple's new Codable interface is easy to use simply, but has powerful potential in more complex situations.", "physmain", "2019-12-13", 2,  "10:10", "10:50", "talk", "ChrisPrice"),
        Talk("coffee5", "Coffee Break", "Coffee and cakes available in the Physics Foyer. ", "foyer", "2019-12-13", 3,  "10:50", "11:20", "coffee", ""),
        Talk("ibawesome", "Interface Builder considered awesome", "Storyboards and XIBs create horrible merge-conficts in teams, are unreviewable in Pull-Requests and they don't even support comments. So no responsible developer in a team should ever be using Interface Builder for a serious iOS project, right?", "physmain", "2019-12-13", 4,  "11:20", "12:00", "talk", "JoachimKurz"),
        Talk("havoc", "Cry 'Havoc!' and let slip the dogs of software", "Scotty explores the wonder of the software industry", "physmain", "2019-12-13", 5,  "12:00", "12:40", "talk", "SteveScott"),
        Talk("hack", "ARKit hack", "This hack session will have the challenge of building a working Apple Watch game.", "b23", "2019-12-13", 6,  "13:30", "23:30", "talk", ""),
    )

    val allLocations = listOf(
        Location("b23", "Llandinam B23", 52.416367,  -4.066299, "The Hack on Thursday afternoon and evening will be run in this workroom."),
        Location("spoons", "Yr Hen Orsaf", 52.414176,  -4.08181, "This cafe is next to the railway station, so handy for meeting when we all arrive."),
        Location("foyer", "Physics Foyer", 52.415941,  -4.065818, "This is the location for the refreshments provided during the conference."),
        Location("physmain", "Physics Main", 52.415941,  -4.065818, "Main lecture theatre for the conference, near where registration happens."),
        Location("a6", "Llandinam A6", 52.41647,  -4.066544, "A6 is on the road below the Physical Sciences building. Turn right and it is about 100 meters on the right."),
        Location("medrus", "Medrus Mawr", 52.417941,  -4.064823, "The conference meal will be in Medrus, which is in the Penbryn building, close to the main entrance to campus.")
    )
    val allSpeakers = listOf(
        Speaker("AdamRush", "adam_rush", "Adam Rush",  "Adam Rush is a passionate iOS developer with over 6 years commercial experience, contracting all over the UK & Europe. He's a tech addict and #Swift enthusiast.", "adam9rush"),
        Speaker("AgnieszkaCzyzak", "agnieszka_czyzak", "Agnieszka Czyak",  "Agnieszka is a UX designer at Polidea.", "agaczyzak"),
        Speaker("AlanMorris", "alan_morris", "Alan Morris",  "With over 16 years in the tech and development industry, for organisations such as Orange and Accenture, Alan ran a successful iOS development agency before joining hedgehog lab to lead the development team.", "dippigu"),
        Speaker("AmyWorrall", "amy_worrall", "Amy Worrall",  "App developer from Coventry, working for Facebook. Likes singing, cooking and playing board games.", "amyruthworrall"),
        Speaker("AndreyKozlov", "andrey_kozlov", "Andrey Kozlov",  "I am a passionate iOS developer. TDD evangelist and Software Architect who cares about quality and creating maintainable and clear code.", "a_rayand"),
        Speaker("ChrisPrice", "chris_price", "Chris Price",  "Chris is one of the organisers for iOSDevUK. He is also a lecturer at Aberystwyth University in Computer Science. He has a number of Apps in the App store to help people to learn Welsh. ", "iOSDevUK"),
        Speaker("ClausHofele", "claus_hofele", "Claus Höfele",  "Claus supports the iOS Team at HERE as a Tech Lead to create personal mobility services for consumers. Author of AlexaSkillsKit and CCHMapClusterController", "claushoefele"),
        Speaker("DanielTull", "daniel_tull", "Daniel Tull ",  "Daniel has been a Cocoa developer since the Java Bridge existed when macOS was known as OS X. He has since made his way up from developing apps for Sky, Tesco, BBC, Nespresso and Danone to the heights of Gok Wan’s glorious fashion app.", "danielctull"),
        Speaker("JoachimKurz", "joachim_kurz", "Joachim Kurz",  "Joachim is working as an iOS developer at Yelp and he likes to give talks about APIs and tools that are super-valuable in day-to-day live but are often overshadowed by discussions about the newest technologies or yet another architecture style. One of his favorite review-comments is 'there is a formatter for that'. He has seen many ways to do formatting badly and many unnecessary `stringWithFormat:` calls and is trying to fight them where possible", "cocoafrog"),
        Speaker("MartinPilkington", "martin_pilkington", "Martin Pilkington",  "Martin has been developing for Apple’s platforms for 13 years. More recently he has been trying to get Objective-C and Swift to play nicely with each other, and ranting on Twitter when they don’t.", "pilky"),
        Speaker("NeilTaylor", "neil_taylor", "Neil Taylor",  "Neil helps out with iOSDevUK and worked on the conference App. He also lectures in Computer Science at Aberystwyth University. He works with Chris Price on the Welsh language apps.", "digidol"),
        Speaker("RebeccaEakins", "rebecca_eakins", "Rebecca Eakins",  "Rebecca focuses on mobile and data science - with a special fondness for the intersection of the two. Before getting into programming, she read a lot of philosophy and literature and finds now that poetry and great code aren’t so different.", "ohrebeccago"),
        Speaker("RossButler", "ross_butler", "Ross Butler",  "Senior iOS Developer at Sainsbury's-Argos in London. Formerly BBC, working on CBeebies, CBBC and iPlayer products. Frequent speaker at meetups and conferences as well as ex-organiser of NSManchester, a meetup for iOS developers in the North-West.", "ross_w_butler"),
        Speaker("SamDavies", "sam_davies", "Sam Davies",  "Sam works writing books and giving training for raywenderlich.com", "iwantmyrealname"),
        Speaker("SteveScott", "steve_scott", "Steve Scott",  "Scotty is legendary in the MAC community as the organiser of the sadly defunct NSConference, but still appearing live at iOSDevUK.", "macdevnet"),
        Speaker("SteveWestgarth", "steve_westgarth", "Steve Westgarth",  "Steve is Engineering Manager at Boots UK.", "stevewestgarth"),
        Speaker("JanieClayton", "janie_clayton", "Janie Clayton",  "Software engineer. Author of the forthcoming Metal Programming Guide. ENFJ. Agent of the revolution. Doer of impossible things.", "redqueencoder"),
        Speaker("SarpErdag", "sarp_erdag", "Sarp Erdag",  "Sarp is a mobile app developer , designer and entrepreneur from Istambul focusing on developing top-notch software products.", "sarperdag"),
        Speaker("ElviroRocca", "elviro_rocca", "Elviro Rocca",  "Elviro worked for some years as a Materials Engineer before focusing on his true passion: functional programming. He is the lead iOS Developer at Facile.it", "_logicist"),
        Speaker("SashZats", "sash_zats", "Sash Zats",  "Sash Zats is a designer and generative artist building toools for designers at Facebook. ", "zats"),
        Speaker("StevenGray", "steven_gray", "Steven Gray",  "Steven works in Oregon for SoftSource Consulting.", "sgray_sftsrc")
    )

    fun speakerNameFromSpeakerId( speakerId: String): String {
        val speakerLookup = allSpeakers.filter { it.id == speakerId }
        var result = ""
        if (speakerLookup.size > 0) {
            result = speakerLookup[0].name
        }
        return result
    }

    fun locationNameFromLocationId( locationId: String): String {
        val locationLookup = allLocations.filter { it.id == locationId }
        var result = ""
        if (locationLookup.size > 0) {
            result = locationLookup[0].name
        }
        return result
    }

    fun speakerIndexFromSpeakerId( speakerId: String): Int {
    var result = 0
       for (speaker in allSpeakers) {
           if (speaker.id == speakerId) { return result }
           else result = result + 1
       }
       return 0
    }


    fun dayName(dateString: String): String {
        var result = "Monday 10th"
        if (dateString == "2019-12-11") {
            result = "Tuesday 11th"
        } else if (dateString == "2019-12-12") {
            result = "Wednesday 12th"
        } else if (dateString == "2019-12-13") {
            result = "Thursday 13th"
        }
        return result
    }

}
