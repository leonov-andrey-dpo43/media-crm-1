<?php

namespace App\Http\Controllers\Api;

use App\Models\Event;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Http\JsonResponse;

class EventController extends Controller
{
    public function index(): JsonResponse
    {
        return response()->json(Event::all());
    }

    public function store(Request $request): JsonResponse
    {
        $event = Event::create($request->only([
            'event_date',
            'region',
            'text',
            'performer',
        ]));

        return response()->json($event, 201);
    }

    public function show(int $id): JsonResponse
    {
        $event = Event::find($id);

        if (!$event) {
            return response()->json(['error' => 'Event not found'], 404);
        }

        return response()->json($event);
    }

    public function update(Request $request, int $id): JsonResponse
    {
        $event = Event::find($id);

        if (!$event) {
            return response()->json(['error' => 'Event not found'], 404);
        }

        $event->update($request->only([
            'event_date',
            'region',
            'text',
            'performer',
        ]));

        return response()->json($event);
    }

    public function destroy(int $id): JsonResponse
    {
        $deleted = Event::destroy($id);

        if (!$deleted) {
            return response()->json(['error' => 'Event not found'], 404);
        }

        return response()->json(['message' => 'Event deleted']);
    }
}
