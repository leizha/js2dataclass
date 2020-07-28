package js2dataclass

import kotlin.test.Test

class Base {
    @Test
    fun testParse() {
        //language=JSON
        val raw = """
{
 "kind": "admin#directory#resources#calendars#calendarResourcesList",
 "etag": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/BEwZVDjHY0vf7KMtccr3J4jGU78\"",
 "items": [
  {
   "kind": "admin#directory#resources#calendars#CalendarResource",
   "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/2cfIKGc41X--DFp9qhkA-RTi1_s\"",
   "resourceId": "10262804537",
   "resourceName": "Passion Fruit Green Tea",
   "generatedResourceName": "Bubble Tea Space SF-4-Passion Fruit Green Tea (2)",
   "resourceType": "Work Room",
   "resourceEmail": "bubbletea.space_188c4r0cvp7r6ik1mr247k3t2ao2g6gb64o34dhi70o38d9j6s@resource.calendar.google.com",
   "capacity": 2,
   "buildingId": "bbt_space_sf",
   "floorName": "4",
   "resourceCategory": "CONFERENCE_ROOM",
   "featureInstances": [
    {
     "feature": {
      "kind": "admin#directory#resources#features#Feature",
      "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/ZGlThTiP_Z0dCMXfH3av4HJLL7s\"",
      "name": "Bean bag chair"
     }
    }
   ]
  },
  {
   "kind": "admin#directory#resources#calendars#CalendarResource",
   "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/J-tlfSuxHJJi-dqQhMLmimYMBYg\"",
   "resourceId": "27127283459",
   "resourceName": "Taro Milk Tea",
   "generatedResourceName": "Bubble Tea Space SF-5-Taro Milk Tea (10) [Zoom]",
   "resourceType": "Meeting Room",
   "resourceEmail": "bubbletea.space_188c17n3kddqmgfgnh059k9q5jtg46gb68rj2chn68s36d1l74@resource.calendar.google.com",
   "capacity": 10,
   "buildingId": "bbt_space_sf",
   "floorName": "5",
   "resourceCategory": "CONFERENCE_ROOM",
   "featureInstances": [
    {
     "feature": {
      "kind": "admin#directory#resources#features#Feature",
      "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/IlbLn-UYyVKZEVJbcnjsbJ0eLDg\"",
      "name": "Zoom"
     }
    },
    {
     "feature": {
      "kind": "admin#directory#resources#features#Feature",
      "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/ZGlThTiP_Z0dCMXfH3av4HJLL7s\"",
      "name": "Bean bag chair"
     }
    }
   ]
  },
  {
   "kind": "admin#directory#resources#calendars#CalendarResource",
   "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/FtexbrHZphUXmrXkpr8kWHwKtQc\"",
   "resourceId": "40692724987",
   "resourceName": "Lychee Fruit Tea",
   "generatedResourceName": "Bubble Tea Space SF-3-Lychee Fruit Tea (5)",
   "resourceType": "Work Room",
   "resourceEmail": "bubbletea.space_1882lbcecljd8icriht5qfco3qv8u6gb6go3ce9i6sp38e9o6s@resource.calendar.google.com",
   "capacity": 5,
   "buildingId": "bbt_space_sf",
   "floorName": "3",
   "resourceCategory": "CONFERENCE_ROOM",
   "featureInstances": [
    {
     "feature": {
      "kind": "admin#directory#resources#features#Feature",
      "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/ZGlThTiP_Z0dCMXfH3av4HJLL7s\"",
      "name": "Bean bag chair"
     }
    }
   ]
  },
  {
   "kind": "admin#directory#resources#calendars#CalendarResource",
   "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/qZ5ygPVLwUDxBEV21EhVvN1p5Ek\"",
   "resourceId": "71260050114",
   "resourceName": "Jasmine Milk Tea",
   "generatedResourceName": "Bubble Tea Space NY-7-Jasmine Milk Tea (3)",
   "resourceType": "Work Room",
   "resourceEmail": "bubbletea.space_188c1eta5vvakgnhjaqs03hp5bjvk6gb6soj4dhg60qj0c9h6g@resource.calendar.google.com",
   "capacity": 3,
   "buildingId": "bbt_space_ny",
   "floorName": "7",
   "resourceCategory": "CONFERENCE_ROOM",
   "featureInstances": [
    {
     "feature": {
      "kind": "admin#directory#resources#features#Feature",
      "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/ZGlThTiP_Z0dCMXfH3av4HJLL7s\"",
      "name": "Bean bag chair"
     }
    }
   ]
  },
  {
   "kind": "admin#directory#resources#calendars#CalendarResource",
   "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/pzcB9Nzg8-dWscrD50kc1NKbLgI\"",
   "resourceId": "79952923734",
   "resourceName": "Chamomile Tea",
   "generatedResourceName": "Bubble Tea Space SF-5-Chamomile Tea (1)",
   "resourceType": "Phone Booth",
   "resourceEmail": "bubbletea.space_1880u4pvugvn0gl0ncdbt5u5mm2o86gb6ssjid9i74p36dpj6g@resource.calendar.google.com",
   "capacity": 1,
   "buildingId": "bbt_space_sf",
   "floorName": "5",
   "resourceCategory": "CONFERENCE_ROOM"
  },
  {
   "kind": "admin#directory#resources#calendars#CalendarResource",
   "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/cbMLZIynl-Khf1Myda56VyPmU08\"",
   "resourceId": "92663176868",
   "resourceName": "Red Bean Milk Tea",
   "generatedResourceName": "Bubble Tea Space NY-10-Red Bean Milk Tea (20) [Zoom]",
   "resourceType": "Meeting Room",
   "resourceEmail": "bubbletea.space_18820m9i6pdukjn9j9il3obtnuoke6gb74p3cdhj64rjce1m70@resource.calendar.google.com",
   "capacity": 20,
   "buildingId": "bbt_space_ny",
   "floorName": "10",
   "resourceCategory": "CONFERENCE_ROOM",
   "featureInstances": [
    {
     "feature": {
      "kind": "admin#directory#resources#features#Feature",
      "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/ZGlThTiP_Z0dCMXfH3av4HJLL7s\"",
      "name": "Bean bag chair"
     }
    },
    {
     "feature": {
      "kind": "admin#directory#resources#features#Feature",
      "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/IlbLn-UYyVKZEVJbcnjsbJ0eLDg\"",
      "name": "Zoom"
     }
    }
   ]
  },
  {
   "kind": "admin#directory#resources#calendars#CalendarResource",
   "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/y7ndEYX0P6esBoFe5VliFgTk8eg\"",
   "resourceId": "9385800171",
   "resourceName": "Oolong Tea",
   "generatedResourceName": "Bubble Tea Space SF-2-Oolong Tea (1)",
   "resourceType": "Phone Booth",
   "resourceEmail": "bubbletea.space_18845o2u00aloi4bidgdmjpe41gt46ga74pjgd9o60o32dph@resource.calendar.google.com",
   "capacity": 1,
   "buildingId": "bbt_space_sf",
   "floorName": "2",
   "resourceCategory": "CONFERENCE_ROOM"
  },
  {
   "kind": "admin#directory#resources#calendars#CalendarResource",
   "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/N5rINljeU5TI6sKXAwOK05IXsjs\"",
   "resourceId": "96786503245",
   "resourceName": "Mango Slush",
   "generatedResourceName": "Bubble Tea Space NY-6-Mango Slush (15) [Zoom]",
   "resourceType": "Meeting Room",
   "resourceEmail": "bubbletea.space_188fgf0nqbc7kj3uj925l2nka203i6gb74r3ee1m6ko36chk6k@resource.calendar.google.com",
   "capacity": 15,
   "buildingId": "bbt_space_ny",
   "floorName": "6",
   "resourceCategory": "CONFERENCE_ROOM",
   "featureInstances": [
    {
     "feature": {
      "kind": "admin#directory#resources#features#Feature",
      "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/ZGlThTiP_Z0dCMXfH3av4HJLL7s\"",
      "name": "Bean bag chair"
     }
    },
    {
     "feature": {
      "kind": "admin#directory#resources#features#Feature",
      "etags": "\"IPXFDecIkpTQhHOhirzOnkZL6DQ/IlbLn-UYyVKZEVJbcnjsbJ0eLDg\"",
      "name": "Zoom"
     }
    }
   ]
  }
 ]
}
        """

        val root = parse(JSON.parse(raw))
        console.log(root.debugType())

        val ctx = TypeContext()
        ctx.gen(root)
        ctx.definitions.forEach { console.log(it) }
    }
}
