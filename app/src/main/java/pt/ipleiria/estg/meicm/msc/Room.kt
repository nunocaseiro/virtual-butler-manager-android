package pt.ipleiria.estg.meicm.msc

data class Room(val roomName: String, val ip: String?) {
    constructor(roomName: String) : this(roomName,null)
}

