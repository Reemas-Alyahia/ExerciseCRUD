package com.example.exercisecrud.Control;

import com.example.exercisecrud.ApiResponse.ApiResponse;
import com.example.exercisecrud.Model.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/track")
public class TrackControl {
    ArrayList<Tracker> trackers = new ArrayList<>();
@GetMapping("/get")
   public ArrayList<Tracker> getTrackers(){
    return trackers;
}

    @PostMapping("/add")
    public ApiResponse addTracker(@RequestBody Tracker tracker) {
    trackers.add(tracker);
    return new ApiResponse("Add tasks");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateTracker(@PathVariable int index,@RequestBody Tracker tracker) {
    trackers.set(index, tracker);
    return new ApiResponse("update tasks");
    }
@DeleteMapping("/delet/{index}")
public ApiResponse deleteTracker(@PathVariable int index) {
    trackers.remove(index);
    return new ApiResponse("delete tasks");
}

//Change the task status as done or not done
    @PutMapping("/change/{index}")
    public ApiResponse changStatus(@PathVariable int index ,@RequestParam String status ) {
    if(index<trackers.size()&&trackers.get(index).getStatus().equals("not done")) {
        trackers.get(index).setStatus("done");
    }
    return new ApiResponse("done for changing status");
    }


    //Search for a task by given title
    @GetMapping("/search")
    public Tracker searchTracker(@RequestParam String title) {
    for(Tracker t : trackers) {
        if(t.getTitle().equals(title)) {
        return t;}
    }
    return null;
    }




}
